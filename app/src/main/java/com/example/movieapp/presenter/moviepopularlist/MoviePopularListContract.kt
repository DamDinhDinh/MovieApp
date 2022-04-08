package com.example.movieapp.presenter.moviepopularlist

import androidx.lifecycle.LiveData
import com.example.movieapp.presenter.model.moviepopular.MoviePopular

interface MoviePopularListContract {
    interface View {
        fun updateViewState(viewState: ViewState)
    }

    interface ViewModel {

        fun fetchMoviePopular()

        fun observeViewState(): LiveData<ViewState>
    }

    data class ViewState(val movieList: List<MoviePopular>)
}