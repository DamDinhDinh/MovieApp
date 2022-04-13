package com.example.movieapp.presenter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.ItemMoviePopularBinding
import com.example.movieapp.presenter.model.moviepopular.MoviePopular


class MoviePopularAdapter(private val onItemClick: (movie: MoviePopular) -> Unit) :
    ListAdapter<MoviePopular, MoviePopularAdapter.ViewHolder>(MoviePopularDiff()) {

    private val TAG = "MoviePopularAdapter"

    class MoviePopularDiff : DiffUtil.ItemCallback<MoviePopular>() {
        override fun areItemsTheSame(oldItem: MoviePopular, newItem: MoviePopular): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MoviePopular, newItem: MoviePopular): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(
        view: View,
        val onItemClick: (movie: MoviePopular) -> Unit
    ) :
        RecyclerView.ViewHolder(view) {

        private val binding: ItemMoviePopularBinding by viewBinding()

        fun bindView(movie: MoviePopular, position: Int) {
            this.binding.run {
                Glide.with(imvPoster).load(movie.posterPath)
                    .into(imvPoster)
                tvTitle.text = root.context.getString(R.string.movie_title_label, movie.title)
                tvReleaseDate.text =
                    root.context.getString(R.string.release_date_label, movie.releaseDate)
                tvAverageRating.text =
                    root.context.getString(
                        R.string.average_rating_label,
                        movie.voteAverage.toString()
                    )

                root.setOnClickListener { onItemClick(movie) }
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
        val movie = getItem(position)
        holder.bindView(movie, position)
    }
}