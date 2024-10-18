package com.example.articlesearch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchArticles { articles ->
            recyclerView.adapter = ArticleAdapter(articles)
        }
    }

    private fun fetchArticles(callback: (List<Article>) -> Unit) {
        val client = AsyncHttpClient()
        val url = "https://api.nytimes.com/svc/search/v2/articlesearch.json?api-key=${BuildConfig.API_KEY}&q=technology"

        client.get(url, object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>?, response: JSONObject?) {
                val articles = parseArticles(response)
                callback(articles)
            }

            override fun onFailure(statusCode: Int, headers: Array<Header>?, throwable: Throwable?, errorResponse: JSONObject?) {
                Log.e("API Error", throwable?.message ?: "Error")
            }
        })
    }

    private fun parseArticles(response: JSONObject?): List<Article> {
        val docs: JSONArray = response?.getJSONObject("response")?.getJSONArray("docs") ?: JSONArray()
        return Gson().fromJson(docs.toString(), Array<Article>::class.java).toList()
    }
}