package com.example.kotlin_newsapi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(supportFragmentManager: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(supportFragmentManager, lifecycle)
{
    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList.get(position)
    }

    fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList.get(position)
    }

    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}