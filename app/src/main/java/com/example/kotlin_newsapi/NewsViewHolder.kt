package com.example.kotlin_newsapi

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_newsapi.model.Article

class NewsViewHolder(containerView: View, private val imageLoader: ImageLoader)
    : RecyclerView.ViewHolder(containerView) {
//        container layout of each item list

        private val newsImage: ImageView = containerView.findViewById(R.id.news_image)
        private val newsTitle: TextView = containerView.findViewById(R.id.news_title)
        private val newsAuthor: TextView = containerView.findViewById(R.id.news_author)

        fun bind(news: Article) {
            newsTitle.text = news.title
            newsAuthor.text = news.author
            val urlToImage = news.urlToImage
            if (!urlToImage.isNullOrEmpty()) {
                imageLoader.loadImage(news.urlToImage, newsImage)
            }
        }
}