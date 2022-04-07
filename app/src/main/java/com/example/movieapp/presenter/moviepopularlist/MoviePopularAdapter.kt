package com.example.movieapp.presenter.moviepopularlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.databinding.ItemMoviePopularBinding
import com.example.movieapp.presenter.model.movie.Movie
import com.example.movieapp.presenter.model.moviepopular.MoviePopular

class MoviePopularAdapter(private val movieList: List<MoviePopular>) :
    RecyclerView.Adapter<MoviePopularAdapter.ViewHolder>() {

    private val TAG = "MoviePopularAdapter"

    class ViewHolder(val itemMoviePopularBinding: ItemMoviePopularBinding) :
        RecyclerView.ViewHolder(itemMoviePopularBinding.root)

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

        println("$TAG onBindViewHolder $movie")

        Glide.with(holder.itemMoviePopularBinding.imgMovieBackdrop).load(movie.backdropPath)
            .into(holder.itemMoviePopularBinding.imgMovieBackdrop)
        holder.itemMoviePopularBinding.tvMovieName.text = movie.originalTitle
        holder.itemMoviePopularBinding.tvReleaseDate.text = movie.releaseDate
        holder.itemMoviePopularBinding.tvRating.text = movie.voteAverage.toString()
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}