package com.example.kotlin_newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.kotlin_newsapi.api.NewsApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    private val newsApiService by lazy{
        retrofit.create(NewsApiService::class.java)
    }

    private val apiResponseView: TextView by lazy{
        findViewById(R.id.api_response)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNewsResponse()
    }

    private fun getNewsResponse() {
        val call = newsApiService.getNews("id", "e5455e7206a647859dcb57a918281d7a")
        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                apiResponseView.text = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "Failed to get response: ", t)
            }
        })
    }

    companion object {
        const val TAG = "MainActivity"
    }

}