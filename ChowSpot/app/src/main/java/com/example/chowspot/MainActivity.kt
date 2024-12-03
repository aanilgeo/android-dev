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

        // Sample data for RecyclerView
        val foodTrucks = listOf("Tasty Tacos", "Pizza Paradise", "Burger Haven")

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FoodTruckAdapter(foodTrucks)

        // Set up BottomNavigationView
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Already showing the Home Screen
                    true
                }
                R.id.favorites -> {
                    // TODO: Replace with Fragment for Favorites
                    true
                }
                R.id.profile -> {
                    // TODO: Replace with Fragment for Profile
                    true
                }
                else -> false
            }
        }
    }
}