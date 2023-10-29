package com.example.kotlin_newsapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kotlin_newsapi.model.Article

class NewsDetail : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve the selected article from the arguments bundle
        val article = arguments?.getParcelable<Article>("article")

        if (article != null) {
            val image = requireView().findViewById<TextView>(R.id.news_image)
            image.text = article.urlToImage

            val title = requireView().findViewById<TextView>(R.id.news_title)
            title.text = article.title

            val author = requireView().findViewById<TextView>(R.id.news_author)
            author.text = article.author
        }
    }
}