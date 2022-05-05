package com.example.movieapp.presenter.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.movieapp.presenter.moviedetail.about.AboutMovieFragment
import com.example.movieapp.presenter.moviedetail.review.ReviewMovieFragment

/**
 * Created by dinhdd damdinhdinh.mum@gmail.com on 4/12/2022.
 */
class AboutMoviePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AboutMovieFragment.newInstance(AboutMovieFragment.Params())
            1 -> ReviewMovieFragment.newInstance(ReviewMovieFragment.Params())
            else -> throw IllegalArgumentException("Page position incorrect")
        }
    }
}