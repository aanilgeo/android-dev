package com.example.chowspot

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.chowspot.NotificationsUtils.createNotificationChannel
import com.example.chowspot.NotificationsUtils.sendFunFactNotification
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val NOTIFICATION_PERMISSION_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Request Notification Permission for Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                NOTIFICATION_PERMISSION_REQUEST_CODE
            )
        }

        // Initialize Notification Channel
        createNotificationChannel(this)

        // Initialize SharedPreferences with consistent file name
        sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

        // Debug: Log the current funFactsEnabled preference
        val isFunFactsEnabled = sharedPreferences.getBoolean("funFactsEnabled", false)
        Log.d("MainActivity", "funFactsEnabled preference value: $isFunFactsEnabled")

        // Check and send Fun Fact Notification if enabled
        if (isFunFactsEnabled) {
            sendFunFactNotification(this)
            Log.d("MainActivity", "Fun Facts Notification Triggered")
        } else {
            Log.d("MainActivity", "Fun Facts Notification Not Enabled")
        }

        // Set up bottom navigation
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Set default fragment
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        // Handle navigation item selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            val selectedFragment = when (item.itemId) {
                R.id.home -> HomeFragment()
                R.id.profile -> ProfileFragment()
                else -> null
            }
            selectedFragment?.let {
                replaceFragment(it)
                true
            } ?: false
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}