package com.example.movieapp.presenter.ui.detail

import com.example.movieapp.presenter.model.movie.Movie
import kotlinx.coroutines.flow.StateFlow

interface MovieDetailContract {
    data class ViewState(val movie: Movie)

    interface ViewModel {

        fun fetchMovie(id: String)

        fun observeViewState(): StateFlow<ViewState?>
    }
}