package com.example.kotlin_newsapi.model

import com.squareup.moshi.Json

data class Article (
    val author: String,
    val title: String,
    @field:Json(name = "urlToImage") val urlToImage: String
)