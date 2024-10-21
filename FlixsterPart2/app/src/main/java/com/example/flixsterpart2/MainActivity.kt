package com.example.flixsterpart2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var rvMovies: RecyclerView
    private lateinit var rvPeople: RecyclerView
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val toolbarTitle: TextView = findViewById(R.id.toolbar_title)
        toolbarTitle.text = "Flixster II"

        rvMovies = findViewById(R.id.rvMovies) // Movies RecyclerView
        rvPeople = findViewById(R.id.rvPeople) // People RecyclerView

        // Set LayoutManagers for RecyclerViews
        rvMovies.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvPeople.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rvMovies.adapter = MovieAdapter(emptyList())
        rvPeople.adapter = PersonAdapter(emptyList())

        fetchMovies()
        fetchPeople()
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
                    Log.e(TAG, "Failed to fetch movies: ${response.message}")
                    return
                }

                response.body?.let {
                    val json = JSONObject(it.string())
                    val moviesArray = json.getJSONArray("results")
                    runOnUiThread {
                        val movies = Movie.fromJsonArray(moviesArray)
                        rvMovies.adapter = MovieAdapter(movies)
                    }
                }
            }
        })
    }

    private fun fetchPeople() {
        val url = "https://api.themoviedb.org/3/person/popular?api_key=${BuildConfig.MOVIE_DB_API_KEY}"

        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(TAG, "Failed to fetch people", e)
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    Log.e(TAG, "Failed to fetch people: ${response.message}")
                    return
                }

                response.body?.let {
                    val json = JSONObject(it.string())
                    Log.d(TAG, json.toString())
                    val peopleArray = json.getJSONArray("results")
                    runOnUiThread {
                        val people = Person.fromJsonArray(peopleArray)
                        rvPeople.adapter = PersonAdapter(people)
                    }
                }
            }
        })
    }
}