package com.example.movieapp.presenter.ui.detail

import androidx.lifecycle.LiveData
import com.example.movieapp.presenter.model.movie.Movie

interface MovieDetailContract {
    data class ViewState(val movie: Movie)

    interface View {
        fun updateViewState(viewState: ViewState)
    }

    interface ViewModel {

        fun fetchMovie(id: Int)

        fun observeViewState(): LiveData<ViewState>
    }
}