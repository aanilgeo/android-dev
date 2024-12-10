package com.example.chowspot

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class FoodTruckDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_truck_details)

        // Retrieve data from Intent
        val truckName = intent.getStringExtra("TRUCK_NAME") ?: "Unknown Truck"
        val truckImage = intent.getStringExtra("TRUCK_IMAGE")
        val truckMenu = intent.getStringExtra("TRUCK_MENU") ?: "No menu available"
        val truckAddress = intent.getStringExtra("TRUCK_ADDRESS") ?: "Address not available"
        val truckRating = intent.getStringExtra("TRUCK_RATING") ?: "N/A"

        // Populate UI
        findViewById<TextView>(R.id.truckName).text = truckName
        findViewById<TextView>(R.id.truckDetails).text = "Address: $truckAddress\nRating: $truckRating"
        Glide.with(this).load(truckImage).into(findViewById(R.id.truckImage))
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}