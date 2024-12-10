package com.example.chowspot

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.chowspot.NotificationsUtils.sendFunFactNotification
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        auth = FirebaseAuth.getInstance()

        val userName = view.findViewById<TextView>(R.id.userName)
        val userEmail = view.findViewById<TextView>(R.id.userEmail)
        val logoutButton = view.findViewById<Button>(R.id.logoutButton)
        val notificationsSwitch = view.findViewById<Switch>(R.id.notificationsSwitch)

        // Initialize SharedPreferences
        sharedPreferences = requireContext().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val isFunFactsEnabled = sharedPreferences.getBoolean("funFactsEnabled", false)
        notificationsSwitch.isChecked = isFunFactsEnabled

        // Fetch and display user information
        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser != null) {
            userName.text = "Name: ${currentUser.displayName ?: "Not provided"}"
            userEmail.text = "Email: ${currentUser.email ?: "Not provided"}"
        } else {
            userName.text = "Name: Not available"
            userEmail.text = "Email: Not available"
            Toast.makeText(context, "User not logged in", Toast.LENGTH_SHORT).show()
        }

        // Logout button functionality
        logoutButton.setOnClickListener {
            auth.signOut()
            Toast.makeText(context, "Logged out successfully", Toast.LENGTH_SHORT).show()
            // Redirect to LoginActivity
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        // Toggle Fun Facts Notifications
        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("funFactsEnabled", isChecked).apply()
            Log.d("ProfileFragment", "funFactsEnabled set to: $isChecked")
            val message = if (isChecked) {
                "Fun Facts Notifications Enabled"
            } else {
                "Fun Facts Notifications Disabled"
            }
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        return view
    }
}