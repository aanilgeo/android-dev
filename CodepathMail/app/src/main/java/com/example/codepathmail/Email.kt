package com.example.codepathmail

class Email(
    val sender: String,
    val title: String,
    val summary: String,
    val date: String,  // New field for date
    val senderImageRes: Int, // Resource ID for sender image
    var isRead: Boolean = false
)

