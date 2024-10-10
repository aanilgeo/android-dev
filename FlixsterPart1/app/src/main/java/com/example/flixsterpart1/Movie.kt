package com.example.flixsterpart1

import org.json.JSONArray

class Movie(
    val title: String,
    val posterPath: String,
    val overview: String
) {
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        title = movieJson.getString("title"),
                        posterPath = movieJson.getString("poster_path"),
                        overview = movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }

    fun getPosterImageUrl(): String {
        return "https://image.tmdb.org/t/p/w500/$posterPath"
    }
}