package com.example.articlesearchpt3

import com.google.gson.annotations.SerializedName

data class BestSellerBook(
    @SerializedName("rank") val rank: Int = 0,
    @SerializedName("title") val title: String = "",
    @SerializedName("author") val author: String = "",
    @SerializedName("book_image") val bookImageUrl: String = "",
    @SerializedName("description") val description: String = "",
    @SerializedName("amazon_product_url") val amazonUrl: String = ""
)
