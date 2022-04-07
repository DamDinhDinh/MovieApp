package com.example.movieapp.presenter.moviepopularlist

import androidx.lifecycle.LiveData
import com.example.movieapp.domain.model.moviepopular.ModelMoviePopular
import com.example.movieapp.presenter.model.movie.Movie
import com.example.movieapp.presenter.model.moviepopular.MoviePopular

interface MoviePopularListContract {
    interface View {
        fun renderMovieList(movieList: List<MoviePopular>)
    }

    interface ViewModel {

        fun fetchMoviePopular()

        fun observeViewState(): LiveData<ViewState>
    }

    data class ViewState(val movieList: List<MoviePopular>)
}