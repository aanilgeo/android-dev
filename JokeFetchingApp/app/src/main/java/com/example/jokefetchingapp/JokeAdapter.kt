package com.example.jokefetchingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter(
    private var jokes: List<String>, // Make jokes mutable by changing the var declaration
    private val onJokeClick: (String) -> Unit
) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_joke, parent, false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(jokes[position], onJokeClick)
    }

    override fun getItemCount(): Int = jokes.size

    inner class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val jokeTextView: TextView = itemView.findViewById(R.id.tvJoke)

        fun bind(joke: String, onJokeClick: (String) -> Unit) {
            jokeTextView.text = joke
            itemView.setOnClickListener { onJokeClick(joke) }
        }
    }

    // Method to update the list of jokes
    fun updateJokes(newJokes: List<String>) {
        jokes = newJokes
        notifyDataSetChanged() // Notify the adapter that the data has changed
    }
}