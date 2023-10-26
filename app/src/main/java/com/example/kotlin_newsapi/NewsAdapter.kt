package com.example.kotlin_newsapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_newsapi.model.Article

class NewsAdapter(private val layoutInflater: LayoutInflater, private val imageLoader: ImageLoader)
    : RecyclerView.Adapter<NewsViewHolder>() {
    private val newsList = mutableListOf<Article>()

    fun setData(news: List<Article>) {
        newsList.clear()
        newsList.addAll(news)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return NewsViewHolder(view, imageLoader)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

}