package com.example.chowspot

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
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
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class FoodTruckDetailsActivity : AppCompatActivity() {

    private val reviews = mutableListOf<ReviewEntity>()
    private lateinit var reviewsAdapter: ReviewAdapter
    private lateinit var truckId: String
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_truck_details)

        truckId = intent.getStringExtra("PLACE_ID") ?: ""
        val truckName = intent.getStringExtra("TRUCK_NAME") ?: "Unknown Truck"
        val truckImage = intent.getStringExtra("TRUCK_IMAGE")
        val truckAddress = intent.getStringExtra("TRUCK_ADDRESS") ?: "Address not available"
        val truckRating = intent.getStringExtra("TRUCK_RATING") ?: "N/A"
        val truckLocation = intent.getStringExtra("TRUCK_LOCATION") ?: ""

        reviewsAdapter = ReviewAdapter(reviews)
        val reviewsRecyclerView = findViewById<RecyclerView>(R.id.reviewsRecyclerView)
        reviewsRecyclerView.layoutManager = LinearLayoutManager(this)
        reviewsRecyclerView.adapter = reviewsAdapter

        fetchReviewsFromFirestore()

        findViewById<Button>(R.id.addReviewButton).setOnClickListener {
            showAddReviewDialog()
        }

        findViewById<Button>(R.id.openMapButton).setOnClickListener {
            if (truckLocation.isNotEmpty()) {
                openGoogleMaps(truckLocation)
            } else {
                showToast("Location not available for this truck.")
            }
        }

        findViewById<TextView>(R.id.truckName).text = truckName
        findViewById<TextView>(R.id.truckDetails).text = "Address: $truckAddress\nRating: $truckRating"

        Glide.with(this)
            .load(truckImage)
            .placeholder(R.drawable.ic_placeholder_image)
            .into(findViewById(R.id.truckImage))
    }

    private fun fetchReviewsFromFirestore() {
        Log.d("FoodTruckDetails", "Fetching reviews for truckId: $truckId")
        db.collection("reviews")
            .whereEqualTo("truckId", truckId)
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { snapshot ->
                reviews.clear()
                for (document in snapshot.documents) {
                    val reviewEntity = document.toObject(ReviewEntity::class.java)
                    reviewEntity?.let { reviews.add(it) }
                }
                reviewsAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { e ->
                showToast("Failed to fetch reviews: ${e.message}")
            }
    }

    private fun showAddReviewDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_review, null)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Add Review")
            .setView(dialogView)
            .create()

        val foodItemField = dialogView.findViewById<TextView>(R.id.foodItemField)
        val userRatingBar = dialogView.findViewById<RatingBar>(R.id.userRatingBar)
        val userCommentField = dialogView.findViewById<TextView>(R.id.userCommentField)
        val submitButton = dialogView.findViewById<Button>(R.id.addReviewButton)

        submitButton.setOnClickListener {
            val foodItem = foodItemField.text.toString()
            val userRating = userRatingBar.rating
            val userComment = userCommentField.text.toString()

            if (foodItem.isEmpty() || userComment.isEmpty()) {
                showToast("All fields are required!")
                return@setOnClickListener
            }

            val newReview = mapOf(
                "truckId" to truckId,
                "foodItem" to foodItem,
                "rating" to userRating,
                "comment" to userComment,
                "timestamp" to FieldValue.serverTimestamp()
            )

            db.collection("reviews")
                .add(newReview)
                .addOnSuccessListener {
                    Log.d("FoodTruckDetails", "Review added for truckId: $truckId")
                    showToast("Review added successfully!")
                    fetchReviewsFromFirestore()
                }
                .addOnFailureListener { e ->
                    Log.e("FoodTruckDetails", "Error adding review: ${e.message}")
                    showToast("Failed to add review.")
                }

            dialog.dismiss()
        }

        dialog.show()
    }

    private fun openGoogleMaps(location: String) {
        val gmmIntentUri = Uri.parse("google.navigation:q=$location")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        } else {
            showToast("Google Maps is not installed.")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}