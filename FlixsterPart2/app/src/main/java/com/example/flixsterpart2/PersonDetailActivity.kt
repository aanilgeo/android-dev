package com.example.flixsterpart2

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.flixsterpart2.databinding.ActivityPersonDetailBinding

class PersonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding object
        binding = ActivityPersonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enable shared element transition
        supportPostponeEnterTransition()

        // Enable back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Retrieve data from intent
        val name = intent.getStringExtra("name")
        val knownFor = intent.getStringExtra("known_for")
        val profileImageUrl = intent.getStringExtra("profile_path")

        // Bind data to views
        binding.tvDetailName.text = name
        binding.tvDetailKnownFor.text = "Known for: $knownFor"

        // Load profile image using Glide and start the transition once image is loaded
        Glide.with(this)
            .load(profileImageUrl)
            .apply(RequestOptions().transform(RoundedCorners(80)))
            .into(binding.ivDetailProfile)

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