package com.example.chowspot

data class ReviewEntity(
    val foodItem: String = "",
    val rating: Float = 0f,
    val comment: String = "",
    val truckId: String = ""
)