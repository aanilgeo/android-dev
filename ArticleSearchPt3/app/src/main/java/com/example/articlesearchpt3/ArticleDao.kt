package com.example.articlesearchpt3

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<Article>)

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<Article>

    @Query("SELECT * FROM articles WHERE webUrl = :url")
    suspend fun getArticleByUrl(url: String): Article?

    @Query("DELETE FROM articles")
    suspend fun deleteAllArticles()

    @Query("SELECT * FROM articles LIMIT :limit OFFSET :offset")
    suspend fun getArticlesWithPagination(limit: Int, offset: Int): List<Article>
}