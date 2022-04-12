package com.example.movieapp.presenter.moviepopularlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ItemMoviePopularBinding
import com.example.movieapp.presenter.model.moviepopular.MoviePopular

class MoviePopularAdapter(
    private val movieList: List<MoviePopular>,
    private val listener: OnItemClick
) :
    RecyclerView.Adapter<MoviePopularAdapter.ViewHolder>() {

    private val TAG = "MoviePopularAdapter"

    class ViewHolder(private val itemMoviePopularBinding: ItemMoviePopularBinding) :
        RecyclerView.ViewHolder(itemMoviePopularBinding.root) {
        fun bindView(movie: MoviePopular, position: Int, listener: OnItemClick) {
            this.itemMoviePopularBinding.run {
                Glide.with(imgMovieBackdrop).load(movie.backdropPath)
                    .into(imgMovieBackdrop)
                tvMovieName.text = movie.originalTitle
                tvReleaseDate.text = movie.releaseDate
                tvRating.text = movie.voteAverage.toString()
                root.setOnClickListener { listener.onClick(position) }
            }
        }
    }

    interface OnItemClick {
        fun onClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMoviePopularBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]

        holder.bindView(movie, position, listener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}