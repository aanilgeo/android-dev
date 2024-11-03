package com.example.articlesearch

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.articlesearch.databinding.ActivityArticleDetailBinding

class ArticleDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val article = intent.getSerializableExtra("article") as? Article

        // Set title, author, and description
        binding.articleTitle.text = article?.headline?.main
        binding.articleAuthor.text = article?.byline?.original
        binding.articleDescription.text = article?.abstractText

        // Load the article image if available
        val imageUrl = "https://www.nytimes.com/${article?.multimedia?.firstOrNull()?.url ?: ""}"
        Glide.with(this)
            .load(imageUrl)
            .into(binding.articleImage)
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