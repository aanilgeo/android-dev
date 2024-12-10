package com.example.chowspot

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("nearbysearch/json")
    fun getNearbyPlaces(
        @Query("location") location: String,
        @Query("radius") radius: String,
        @Query("type") type: String,
        @Query("keyword") keyword: String?,
        @Query("key") apiKey: String
    ): Call<FoodTruckResponse>
}
