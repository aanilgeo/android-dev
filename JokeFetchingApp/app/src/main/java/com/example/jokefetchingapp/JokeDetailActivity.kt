package com.example.jokefetchingapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class JokeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_detail)

        // Enable the up button in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get the joke passed from the intent
        val joke = intent.getStringExtra("joke") ?: "No joke found"

        // Display the joke in the TextView
        val jokeTextView: TextView = findViewById(R.id.tvJokeDetail)
        jokeTextView.text = joke

        // Share joke on Twitter
        val shareTwitterButton: Button = findViewById(R.id.btnShareX)
        shareTwitterButton.setOnClickListener {
            shareOnSocialMedia(joke, "x")
        }

        // Share joke on Facebook
        val shareFacebookButton: Button = findViewById(R.id.btnShareFacebook)
        shareFacebookButton.setOnClickListener {
            shareOnSocialMedia(joke, "facebook")
        }
    }

    // Handle the action when the up button is pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Go back to the previous activity (MainActivity)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Method to share on social media
    private fun shareOnSocialMedia(joke: String, platform: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, joke)

        when (platform) {
            "twitter" -> shareIntent.setPackage("com.twitter.android")
            "facebook" -> shareIntent.setPackage("com.facebook.katana")
        }

        try {
            startActivity(shareIntent)
        } catch (e: Exception) {
            Toast.makeText(this, "App not installed", Toast.LENGTH_SHORT).show()
        }
    }
}

