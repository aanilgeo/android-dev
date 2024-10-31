package com.example.articlesearch

import java.io.Serializable

data class Article(
    val headline: Headline,
    val abstract: String,
    val byline: Byline,
    val multimedia: List<Multimedia>
) : Serializable

data class Headline(val main: String) : Serializable
data class Byline(val original: String) : Serializable
data class Multimedia(val url: String) : Serializable
