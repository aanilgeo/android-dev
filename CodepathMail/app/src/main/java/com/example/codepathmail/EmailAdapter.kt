package com.example.codepathmail

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>() {

    // ViewHolder class that provides references to the views for each data item
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderImageView: ImageView = itemView.findViewById(R.id.senderImageView)
        val senderTextView: TextView = itemView.findViewById(R.id.senderTv)
        val titleTextView: TextView = itemView.findViewById(R.id.titleTv)
        val summaryTextView: TextView = itemView.findViewById(R.id.summaryTv)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTv)
    }

    // Inflates the item layout and creates the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val itemView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(itemView)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return emails.size
    }

    // Binds the data to the views in each ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails[position]
        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary
        holder.dateTextView.text = email.date
        holder.senderImageView.setImageResource(email.senderImageRes)

        // Apply bold style based on read status
        if (!email.isRead) {
            holder.senderTextView.setTypeface(null, Typeface.BOLD)
            holder.titleTextView.setTypeface(null, Typeface.BOLD)
        } else {
            holder.senderTextView.setTypeface(null, Typeface.NORMAL)
            holder.titleTextView.setTypeface(null, Typeface.NORMAL)
        }

        // Set OnClickListener to mark email as read when clicked
        holder.itemView.setOnClickListener {
            if (!email.isRead) {
                email.isRead = true
                notifyItemChanged(position) // Refresh item to update style
            }
        }
    }
}