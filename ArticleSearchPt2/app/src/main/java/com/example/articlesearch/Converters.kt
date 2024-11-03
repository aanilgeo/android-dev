package com.example.articlesearch

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromMultimediaList(multimedia: List<Multimedia>?): String {
        return gson.toJson(multimedia)
    }

    @TypeConverter
    fun toMultimediaList(data: String): List<Multimedia> {
        val listType = object : TypeToken<List<Multimedia>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun fromHeadline(headline: Headline?): String {
        return gson.toJson(headline)
    }

    @TypeConverter
    fun toHeadline(data: String): Headline {
        return gson.fromJson(data, Headline::class.java)
    }

    @TypeConverter
    fun fromByline(byline: Byline?): String {
        return gson.toJson(byline)
    }

    @TypeConverter
    fun toByline(data: String): Byline {
        return gson.fromJson(data, Byline::class.java)
    }
}
