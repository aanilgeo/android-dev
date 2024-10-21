package com.example.flixsterpart2

import org.json.JSONArray

class Person(
    val name: String,
    val profilePath: String,
    val knownFor: String
) {
    companion object {
        fun fromJsonArray(personJsonArray: JSONArray): List<Person> {
            val people = mutableListOf<Person>()
            for (i in 0 until personJsonArray.length()) {
                val personJson = personJsonArray.getJSONObject(i)

                // Fix the fields to match the response for people
                val knownForArray = personJson.getJSONArray("known_for")
                val knownForTitles = StringBuilder()
                for (j in 0 until knownForArray.length()) {
                    val knownForObject = knownForArray.getJSONObject(j)
                    if (knownForObject.has("title")) {
                        knownForTitles.append(knownForObject.getString("title")).append(", ")
                    } else if (knownForObject.has("name")) {
                        knownForTitles.append(knownForObject.getString("name")).append(", ")
                    }
                }

                people.add(
                    Person(
                        name = personJson.getString("name"), // Ensure "name" is used instead of "title"
                        profilePath = personJson.getString("profile_path"),
                        knownFor = knownForTitles.toString().trimEnd(',', ' ')
                    )
                )
            }
            return people
        }
    }

    fun getProfileImageUrl(): String {
        return "https://image.tmdb.org/t/p/w500/$profilePath"
    }
}
