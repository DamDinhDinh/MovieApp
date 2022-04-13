package com.example.movieapp.presenter.common.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movieapp.presenter.moviedetail.AboutMovieFragment

/**
 * Created by dinhdd damdinhdinh.mum@gmail.com on 4/12/2022.
 */
class AboutMoviePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2

    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> AboutMovieFragment()
            else -> AboutMovieFragment() //not finish implement yet
        }
    }
}