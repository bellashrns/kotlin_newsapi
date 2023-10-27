package com.example.kotlin_newsapi

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlin_newsapi.api.NewsApiService
import com.example.kotlin_newsapi.model.NewsData
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val name = intent.getStringExtra(name)
        val resultMessage = findViewById<TextView>(R.id.nameResult)
        resultMessage.text = getString(R.string.name_result, name)

        setUpTabs()
    }

    private fun setUpTabs() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPagerAdapter.addFragment(NewsList(), "News")
        viewPagerAdapter.addFragment(Profile(), "Profile")

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = viewPagerAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = viewPagerAdapter.getPageTitle(position)
        }.attach()
    }

    companion object {
        const val TAG = "HomeActivity"
        const val name = "name"
    }
}