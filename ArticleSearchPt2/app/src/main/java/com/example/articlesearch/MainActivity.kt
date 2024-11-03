package com.example.articlesearch

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var articleDatabase: ArticleDatabase
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private var isConnected = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the database first
        articleDatabase = ArticleDatabase.getDatabase(this)

        // Access SharedPreferences for cache preference
        val sharedPreferences = getSharedPreferences("com.example.articlesearch_preferences", Context.MODE_PRIVATE)
        val shouldCache = sharedPreferences.getBoolean("cache_preference", true)

        // Setup toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize SwipeRefreshLayout and RecyclerView
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load articles based on network availability and caching preferences
        loadArticles(shouldCache)

        // Set up SwipeRefreshLayout to force a new network call when pulled
        swipeRefreshLayout.setOnRefreshListener {
            loadArticles(forceNetworkCall = true)
        }

        // Register the network connectivity broadcast receiver
        registerReceiver(connectivityReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    // Inflate the menu to show the settings option
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Handle settings menu option selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadArticles(shouldCache: Boolean = true, forceNetworkCall: Boolean = false) {
        if (isOnline(this) && (forceNetworkCall || shouldCache)) {
            fetchArticles { articles ->
                Log.d("MainActivity", "Articles to Adapter: $articles")
                recyclerView.adapter = ArticleAdapter(articles)
                if (shouldCache) {
                    saveArticlesToDatabase(articles)
                }
                swipeRefreshLayout.isRefreshing = false
            }
        } else if (!isOnline(this)) {
            loadArticlesFromDatabase { articles ->
                Log.d("MainActivity", "Offline Articles to Adapter: $articles")
                recyclerView.adapter = ArticleAdapter(articles)
                swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    private fun fetchArticles(callback: (List<Article>) -> Unit) {
        val client = AsyncHttpClient()
        val url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=${BuildConfig.API_KEY}&q=technology"

        client.get(url, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>?, response: JSONObject?) {
                Log.d("MainActivity", "API Response: $response")
                val articles = parseArticles(response)
                Log.d("MainActivity", "Parsed Articles: $articles")
                callback(articles)
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                Log.e("API Error", "Error fetching articles: ${throwable?.message}")
                swipeRefreshLayout.isRefreshing = false
            }
        })
    }

    private fun saveArticlesToDatabase(articles: List<Article>) {
        lifecycleScope.launch(Dispatchers.IO) {
            articleDatabase.articleDao().insertAll(articles)
        }
    }

    private fun loadArticlesFromDatabase(callback: (List<Article>) -> Unit) {
        lifecycleScope.launch(Dispatchers.IO) {
            val articles = articleDatabase.articleDao().getAllArticles()
            withContext(Dispatchers.Main) {
                callback(articles)
            }
        }
    }

    private fun parseArticles(response: JSONObject?): List<Article> {
        val docs: JSONArray = response?.getJSONObject("response")?.getJSONArray("docs") ?: JSONArray()
        val articles = Gson().fromJson(docs.toString(), Array<Article>::class.java).toList()
        return articles.filter { !it.webUrl.isNullOrBlank() }
    }

    private fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    private val connectivityReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            val newConnectionStatus = isOnline(context)
            if (newConnectionStatus != isConnected) {
                isConnected = newConnectionStatus
                if (isConnected) {
                    Toast.makeText(context, "Connected to the Internet", Toast.LENGTH_SHORT).show()
                    loadArticles(forceNetworkCall = true)
                } else {
                    Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(connectivityReceiver)
    }
}