package com.example.kotlin_newsapi.model

data class NewsData(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)