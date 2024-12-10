package com.example.chowspot

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class SignUpFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        auth = FirebaseAuth.getInstance()

        val nameField = view.findViewById<EditText>(R.id.nameField)
        val emailField = view.findViewById<EditText>(R.id.emailField)
        val passwordField = view.findViewById<EditText>(R.id.passwordField)
        val signupButton = view.findViewById<Button>(R.id.signupButton)

        // Handle sign-up
        signupButton.setOnClickListener {
            val name = nameField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (validateInput(name, email, password)) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            val profileUpdates = UserProfileChangeRequest.Builder()
                                .setDisplayName(name)
                                .build()
                            user?.updateProfile(profileUpdates)
                                ?.addOnCompleteListener { profileTask ->
                                    if (profileTask.isSuccessful) {
                                        Toast.makeText(context, "Signup successful.", Toast.LENGTH_LONG).show()
                                        // Redirect to LoginFragment
                                        activity?.supportFragmentManager?.popBackStack()
                                    }
                                }
                        } else {
                            Toast.makeText(context, "Signup failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
        return view
    }

    private fun validateInput(name: String, email: String, password: String): Boolean {
        if (name.isEmpty()) {
            Toast.makeText(context, "Name is required", Toast.LENGTH_LONG).show()
            return false
        }
        if (email.isEmpty()) {
            Toast.makeText(context, "Email is required", Toast.LENGTH_LONG).show()
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(context, "Please enter a valid email", Toast.LENGTH_LONG).show()
            return false
        }
        if (password.isEmpty()) {
            Toast.makeText(context, "Password is required", Toast.LENGTH_LONG).show()
            return false
        }
        if (password.length < 6) {
            Toast.makeText(context, "Password must be at least 6 characters", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}