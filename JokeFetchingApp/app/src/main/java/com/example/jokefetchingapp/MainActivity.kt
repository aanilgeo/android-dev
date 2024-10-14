package com.example.jokefetchingapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var jokeAdapter: JokeAdapter
    private lateinit var jokeList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        jokeList = findViewById(R.id.rvJokes)
        jokeList.layoutManager = LinearLayoutManager(this)

        // Initialize adapter with an empty list and a click listener
        jokeAdapter = JokeAdapter(emptyList()) { joke ->
            // Navigate to JokeDetailActivity to show the joke in a centered format
            val intent = Intent(this, JokeDetailActivity::class.java)
            intent.putExtra("joke", joke)
            startActivity(intent)
        }
        jokeList.adapter = jokeAdapter

        // Fetch list of jokes from API
        val jokeApiClient = JokeApiClient()
        jokeApiClient.fetchJokes(onSuccess = { jokes ->
            runOnUiThread {
                // Update the adapter's dataset without reinitializing it
                jokeAdapter.updateJokes(jokes)
            }
        }, onFailure = { errorMessage ->
            Log.e(TAG, "Failed to fetch jokes: $errorMessage")
        })
    }
}