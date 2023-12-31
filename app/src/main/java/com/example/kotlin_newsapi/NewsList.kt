package com.example.kotlin_newsapi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_newsapi.api.NewsApiService
import com.example.kotlin_newsapi.model.Article
import com.example.kotlin_newsapi.model.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NewsList : Fragment() {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    private val newsApiService by lazy{
        retrofit.create(NewsApiService::class.java)
    }

    private val recyclerView: RecyclerView by lazy{
        requireView().findViewById<RecyclerView>(R.id.recycler_view)
    }

    private val newsAdapter by lazy {
        NewsAdapter(layoutInflater, GlideLoader(requireContext()))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        getNewsResponse()

        newsAdapter.onItemClick = { article ->
            navigateToNewsDetail(article)
        }
    }

    @SuppressLint("ResourceType")
    private fun navigateToNewsDetail(article: Article) {
        val newsDetailFragment = NewsDetail()
        val bundle = Bundle()
        bundle.putParcelable("article", article) // Pass the selected article as a Parcelable
        newsDetailFragment.arguments = bundle

        // Replace the current fragment with NewsDetail
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.recycler_view, newsDetailFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun getNewsResponse() {
        val call = newsApiService.getNews("us", "e5455e7206a647859dcb57a918281d7a")
        call.enqueue(object : Callback<NewsData> {
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                if (response.isSuccessful) {
                    val newsResponse = response.body()
                    val articles = newsResponse?.articles

                    articles?.let {
                        newsAdapter.setData(it)
                    }

                    Log.d(TAG, "Response success: $articles")
                } else {
                    Log.e(TAG, "Response failed: ${response.errorBody().toString()}")
                }
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Log.e(TAG, "Failed to get response: ", t)
            }
        })
    }

    companion object {
        const val TAG = "NewsList"
    }
}