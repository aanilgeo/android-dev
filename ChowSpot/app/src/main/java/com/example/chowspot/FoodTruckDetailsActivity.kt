package com.example.chowspot

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoodTruckDetailsActivity : AppCompatActivity() {

    private val reviews = mutableListOf<Review>() // In-memory list for reviews
    private lateinit var reviewsAdapter: ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_truck_details)

        // Retrieve data from Intent
        val truckName = intent.getStringExtra("TRUCK_NAME") ?: "Unknown Truck"
        val truckImage = intent.getStringExtra("TRUCK_IMAGE")
        val truckAddress = intent.getStringExtra("TRUCK_ADDRESS") ?: "Address not available"
        val truckRating = intent.getStringExtra("TRUCK_RATING") ?: "N/A"

        // Set up RecyclerView for reviews
        reviewsAdapter = ReviewAdapter(reviews)
        val reviewsRecyclerView = findViewById<RecyclerView>(R.id.reviewsRecyclerView)
        reviewsRecyclerView.layoutManager = LinearLayoutManager(this)
        reviewsRecyclerView.adapter = reviewsAdapter

        // Add one pre-populated review
        reviews.add(Review("Alice", 4.5f, "Great food!"))
        reviewsAdapter.notifyDataSetChanged()

        // Add Review button functionality
        findViewById<Button>(R.id.addReviewButton).setOnClickListener {
            showAddReviewDialog()
        }

        // Populate UI
        findViewById<TextView>(R.id.truckName).text = truckName
        findViewById<TextView>(R.id.truckDetails).text = "Address: $truckAddress\nRating: $truckRating"
        Glide.with(this).load(truckImage).into(findViewById(R.id.truckImage))
    }

    private fun showAddReviewDialog() {
        // Inflate custom dialog view
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_review, null)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Add Review")
            .setView(dialogView)
            .create()

        val userNameField = dialogView.findViewById<TextView>(R.id.userNameField)
        val userRatingBar = dialogView.findViewById<RatingBar>(R.id.userRatingBar)
        val userCommentField = dialogView.findViewById<TextView>(R.id.userCommentField)
        val submitButton = dialogView.findViewById<Button>(R.id.addReviewButton)

        submitButton.setOnClickListener {
            val userName = userNameField.text.toString()
            val userRating = userRatingBar.rating
            val userComment = userCommentField.text.toString()

            if (userName.isEmpty() || userComment.isEmpty()) {
                showToast("All fields are required!")
                return@setOnClickListener
            }

            val newReview = Review(userName, userRating, userComment)
            reviews.add(newReview) // Add review to the in-memory list
            reviewsAdapter.notifyDataSetChanged() // Notify adapter about data changes
            showToast("Review added successfully!")

            dialog.dismiss()
        }

        dialog.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}