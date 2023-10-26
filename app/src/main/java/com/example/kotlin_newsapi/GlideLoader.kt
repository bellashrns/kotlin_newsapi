package com.example.kotlin_newsapi

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideLoader(private val context: Context) : ImageLoader {
    override fun loadImage(urlToImage: String, imageView: ImageView) {
        Glide.with(context)
            .load(urlToImage)
            .centerCrop()
            .into(imageView)
    }

}