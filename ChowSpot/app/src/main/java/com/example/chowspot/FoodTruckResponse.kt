package com.example.chowspot

import com.google.gson.annotations.SerializedName

data class FoodTruckResponse(
    @SerializedName("results")
    val results: List<FoodTruck>
)
