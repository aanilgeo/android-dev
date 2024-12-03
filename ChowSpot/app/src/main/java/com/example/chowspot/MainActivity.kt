package com.example.chowspot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sample data for the RecyclerView
        val foodTrucks = listOf("Truck A", "Truck B", "Truck C")

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FoodTruckAdapter(foodTrucks)

        // Set up BottomNavigationView
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Handle Home Tab click
                    true
                }
                R.id.favorites -> {
                    // Handle Favorites Tab click
                    true
                }
                R.id.profile -> {
                    // Handle Profile Tab click
                    true
                }
                else -> false
            }
        }
    }
}