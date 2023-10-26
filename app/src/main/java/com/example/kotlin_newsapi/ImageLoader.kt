package com.example.kotlin_newsapi

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(urlToImage: String, imageView: ImageView)
}