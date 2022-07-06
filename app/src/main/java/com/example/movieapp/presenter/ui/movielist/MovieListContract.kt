package com.example.movieapp.presenter.ui.movielist

import androidx.lifecycle.LiveData
import com.example.movieapp.presenter.model.movie.Movie

interface MovieListContract {
    interface View {
        fun updateViewState(viewState: ViewState)
    }

    interface ViewModel {

        fun fetchMoviePopular()

        fun observeViewState(): LiveData<ViewState>
    }

    data class ViewState(val movieList: List<Movie>)
}