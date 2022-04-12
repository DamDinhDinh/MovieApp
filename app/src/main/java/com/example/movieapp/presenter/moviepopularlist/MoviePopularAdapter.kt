package com.example.movieapp.presenter.moviepopularlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemMoviePopularBinding
import com.example.movieapp.presenter.common.adapter.BaseRvAdapter
import com.example.movieapp.presenter.common.adapter.OnItemClick
import com.example.movieapp.presenter.model.moviepopular.MoviePopular


class MoviePopularAdapter(private val onItemClick: OnItemClick<MoviePopular>) :
    BaseRvAdapter<MoviePopular, MoviePopularAdapter.ViewHolder>() {

    private val TAG = "MoviePopularAdapter"

    class ViewHolder(
        view: View,
        val onItemClick: OnItemClick<MoviePopular>
    ) :
        RecyclerView.ViewHolder(view) {

        private val binding: ItemMoviePopularBinding by viewBinding()

        fun bindView(movie: MoviePopular, position: Int) {
            this.binding.run {
                Glide.with(imgMovieBackdrop).load(movie.backdropPath)
                    .into(imgMovieBackdrop)
                tvMovieName.text = movie.originalTitle
                tvReleaseDate.text = movie.releaseDate
                tvRating.text = movie.voteAverage.toString()
                root.setOnClickListener { onItemClick.onClick(movie, position) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie_popular, parent, false)

        return ViewHolder(
            view, onItemClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = itemList[position]
        holder.bindView(movie, position)
    }
}