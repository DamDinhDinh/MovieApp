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
import com.example.movieapp.databinding.ItemMovieBinding
import com.example.movieapp.presenter.model.movie.Movie


class MovieAdapter(private val onItemClick: (movie: Movie) -> Unit) :
    ListAdapter<Movie, MovieAdapter.ViewHolder>(MovieDiff()) {

    private val TAG = "MovieAdapter"

    class MovieDiff : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder(
        view: View,
        val onItemClick: (movie: Movie) -> Unit
    ) :
        RecyclerView.ViewHolder(view) {

        private var movie: Movie? = null

        private val binding: ItemMovieBinding by viewBinding()

        init {
            binding.root.setOnClickListener { movie?.let { onItemClick(it) } }
        }

        fun bindView(movie: Movie) {
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

            }

            this.movie = movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)

        return ViewHolder(
            view, onItemClick
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bindView(movie)
    }
}