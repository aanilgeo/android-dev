package com.example.articlesearchpt3

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromMultimediaList(multimedia: List<Multimedia>?): String {
        return multimedia?.let { gson.toJson(it) } ?: "[]"
    }

    @TypeConverter
    fun toMultimediaList(data: String?): List<Multimedia> {
        if (data.isNullOrEmpty()) return emptyList()
        val listType = object : TypeToken<List<Multimedia>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromHeadline(headline: Headline?): String {
        return headline?.let { gson.toJson(it) } ?: "{}"
    }

    @TypeConverter
    fun toHeadline(data: String?): Headline {
        if (data.isNullOrEmpty()) return Headline("")
        return gson.fromJson(data, Headline::class.java)
    }

    @TypeConverter
    fun fromByline(byline: Byline?): String {
        return byline?.let { gson.toJson(it) } ?: "{}"
    }

    @TypeConverter
    fun toByline(data: String?): Byline {
        if (data.isNullOrEmpty()) return Byline(null)
        return gson.fromJson(data, Byline::class.java)
    }
}