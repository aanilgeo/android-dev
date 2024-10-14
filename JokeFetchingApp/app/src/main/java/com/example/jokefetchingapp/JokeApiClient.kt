package com.example.jokefetchingapp

import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class JokeApiClient {
    private val client = OkHttpClient()
    private val TAG = "JokeApiClient"

    fun fetchJokes(onSuccess: (List<String>) -> Unit, onFailure: (String) -> Unit) {
        val request = Request.Builder()
            .url("https://dad-jokes.p.rapidapi.com/joke/type/knock-knock")
            .get()
            .addHeader("x-rapidapi-key", BuildConfig.JOKE_API_KEY)
            .addHeader("x-rapidapi-host", "dad-jokes.p.rapidapi.com")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                onFailure(e.message ?: "Unknown error")
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    onFailure("Failed to fetch jokes: ${response.message}")
                    return
                }

                response.body?.let { responseBody ->
                    val json = JSONObject(responseBody.string())
                    val jokesArray = json.getJSONArray("body")  // Access the list of jokes

                    // Parse jokes and pass them to the onSuccess callback
                    val jokes = mutableListOf<String>()
                    for (i in 0 until jokesArray.length()) {
                        val jokeObj = jokesArray.getJSONObject(i)
                        val joke = jokeObj.getString("setup") + "\n" + jokeObj.getString("punchline")
                        jokes.add(joke)
                    }

                    onSuccess(jokes)
                } ?: run {
                    onFailure("Empty response body")
                }
            }
        })
    }
}

