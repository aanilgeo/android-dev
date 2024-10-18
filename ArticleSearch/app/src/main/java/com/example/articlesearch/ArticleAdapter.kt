package com.example.articlesearch

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
        holder.title.text = article.headline.main
        holder.description.text = article.abstract

        Glide.with(holder.itemView.context)
            .load("https://www.nytimes.com/" + article.multimedia[0].url)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, ArticleDetailActivity::class.java)
            intent.putExtra("article", article)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = articles.size
}