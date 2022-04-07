package com.example.movieapp.data.entities.movie

import com.example.movieapp.presenter.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class JsonListMovieResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Movie>,
    @SerializedName("total_results")
    val totalResult: Int,
    @SerializedName("total_pages")
    val totalPages: Int

)