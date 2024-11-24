package com.example.articlesearchpt3

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "articles")
data class Article(
    @PrimaryKey
    @SerializedName("web_url")
    val webUrl: String,
    @SerializedName("abstract")
    val abstractText: String = "",
    val multimedia: List<Multimedia> = emptyList(),
    val headline: Headline = Headline(""),
    val byline: Byline? = null
) : Serializable

data class Headline(
    @SerializedName("main")
    val main: String = ""
) : Serializable

data class Byline(
    @SerializedName("original")
    val original: String? = null
) : Serializable

data class Multimedia(
    @SerializedName("url")
    val url: String = ""
) : Serializable
