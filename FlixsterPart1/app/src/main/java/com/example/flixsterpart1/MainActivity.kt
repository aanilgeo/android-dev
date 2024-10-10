package com.example.flixsterpart1

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var rvMovies: RecyclerView
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        val toolbarTitle: TextView = findViewById(R.id.toolbar_title)
        toolbarTitle.text = "Flixster"

        rvMovies = findViewById(R.id.rvMovies)

        // Set up the RecyclerView with appropriate LayoutManager
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // GridLayoutManager for landscape mode with 2 columns
            rvMovies.layoutManager = GridLayoutManager(this, 2)
        } else {
            // LinearLayoutManager for portrait mode
            rvMovies.layoutManager = LinearLayoutManager(this)
        }

        // Fetch movies data
        fetchMovies()
    }

    private fun fetchMovies() {
        val url = "https://api.themoviedb.org/3/movie/now_playing?api_key=${BuildConfig.MOVIE_DB_API_KEY}"

        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, "Failed to fetch movies", e)
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    Log.e(TAG, "Failed response from the server: ${response.message}")
                    return
                }

                response.body?.let {
                    val json = JSONObject(it.string())
                    if (json.has("results")) {
                        val moviesArray = json.getJSONArray("results")

                        // Parse JSON and update UI (run on main thread)
                        runOnUiThread {
                            val movies = Movie.fromJsonArray(moviesArray)
                            rvMovies.adapter = MovieAdapter(movies)
                        }
                    } else {
                        Log.e(TAG, "No 'results' found in the response")
                    }
                } ?: Log.e(TAG, "Empty response body")
            }
        })
    }
}