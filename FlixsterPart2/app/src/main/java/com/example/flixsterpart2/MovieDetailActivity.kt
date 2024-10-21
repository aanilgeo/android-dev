package com.example.flixsterpart2

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.flixsterpart2.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding object
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable shared element transition
        supportPostponeEnterTransition()

        // Enable back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Retrieve data from intent
        val title = intent.getStringExtra("title")
        val overview = intent.getStringExtra("overview")
        val posterImageUrl = intent.getStringExtra("poster_path")

        // Bind data to views
        binding.tvDetailTitle.text = title
        binding.tvDetailOverview.text = overview

        // Load poster image using Glide and start the transition once image is loaded
        Glide.with(this)
            .load(posterImageUrl)
            .apply(RequestOptions().transform(RoundedCorners(80)))
            .into(binding.ivDetailPoster)

        // Start the shared element transition
        supportStartPostponedEnterTransition()
    }

    // Handle back button press with transition
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                ActivityCompat.finishAfterTransition(this) // Ensure smooth transition on back
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
