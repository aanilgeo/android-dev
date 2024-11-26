package com.example.articlesearchpt3

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.articlesearchpt3.databinding.ActivityArticleDetailBinding

class ArticleDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val article = intent.getSerializableExtra("article") as? Article

        if (article != null) {
            // Set title, author, and description
            binding.articleTitle.text = article.headline.main.ifEmpty { "No Title Available" }
            binding.articleAuthor.text = article.byline?.original ?: "No Author Available"
            binding.articleDescription.text = article.abstractText.ifEmpty { "No Description Available" }

            // Load the article image if available
            val imageUrl = "https://www.nytimes.com/${article.multimedia.firstOrNull()?.url ?: ""}"
            Glide.with(this)
                .load(imageUrl)
                .into(binding.articleImage)
        } else {
            // Handle missing article data
            Toast.makeText(this, "Error loading article details", Toast.LENGTH_SHORT).show()
            finish() // Close the activity if no data is available
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}