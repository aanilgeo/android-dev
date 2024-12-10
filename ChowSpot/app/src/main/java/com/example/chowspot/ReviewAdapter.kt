package com.example.chowspot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewAdapter(private val reviews: List<ReviewEntity>) :
    RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodItem: TextView = view.findViewById(R.id.foodItemField)
        val ratingBar: RatingBar = view.findViewById(R.id.ratingBar)
        val comment: TextView = view.findViewById(R.id.comment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val review = reviews[position]
        holder.foodItem.text = review.foodItem
        holder.ratingBar.rating = review.rating
        holder.comment.text = review.comment
    }

    override fun getItemCount(): Int {
        return reviews.size
    }
}