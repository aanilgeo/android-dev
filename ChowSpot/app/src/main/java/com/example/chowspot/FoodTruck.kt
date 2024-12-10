package com.example.chowspot

import com.google.gson.annotations.SerializedName

data class FoodTruck(
    val name: String,
    @SerializedName("vicinity") val address: String,
    @SerializedName("rating") val rating: Double?,
    @SerializedName("opening_hours") val isOpen: OpeningHours?,
    @SerializedName("photos") val photoReference: List<Photo>?,
    @SerializedName("geometry") val geometry: Geometry
)

data class OpeningHours(
    @SerializedName("open_now") val isOpenNow: Boolean?
)

data class Photo(
    @SerializedName("photo_reference") val photoReference: String
)

data class Geometry(
    @SerializedName("location") val location: Location
)

data class Location(
    val lat: Double,
    val lng: Double
)