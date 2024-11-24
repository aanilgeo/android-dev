package com.example.articlesearchpt3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ArticleAdapter(private val articles: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    companion object {
        const val ARTICLE_KEY = "article"
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.articleTitle)
        val description: TextView = itemView.findViewById(R.id.articleDescription)
        val imageView: ImageView = itemView.findViewById(R.id.articleImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]

        // Set title and description with fallback values
        holder.title.text = article.headline.main.ifEmpty { "No Title Available" }
        holder.description.text = article.abstractText.ifEmpty { "No Description Available" }

        // Load image with placeholder and error handling
        val imageUrl = "https://www.nytimes.com/${article.multimedia.firstOrNull()?.url ?: ""}"
        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.imageView)

        holder.imageView.contentDescription = article.headline.main

        // Set click listener to navigate to ArticleDetailActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ArticleDetailActivity::class.java)
            intent.putExtra(ARTICLE_KEY, article)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = articles.size
}
