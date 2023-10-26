package com.example.kotlin_newsapi.api

import com.example.kotlin_newsapi.model.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    fun getNews(
        @Query("country") query: String,
        @Query("apiKey") apiKey: String
    ): Call<String>
}