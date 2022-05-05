package com.example.movieapp.presenter.moviedetail.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.example.movieapp.presenter.moviedetail.MovieDetailContract
import com.example.movieapp.presenter.moviedetail.controller.model.movieDetailHeader
import javax.inject.Inject

class MovieDetailController @Inject constructor(): TypedEpoxyController<MovieDetailContract.ViewState>() {

    override fun buildModels(data: MovieDetailContract.ViewState?) {
        data?.movie?.apply {
            movieDetailHeader {
                id("MOVIE_DETAIL_HEADER")
                movieBackDropUrl(backdropPathFull)
                movieAvatarUrl(posterPathFull)
                movieTitle(title)
            }
        }
    }
}