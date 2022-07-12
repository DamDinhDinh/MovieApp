package com.example.movieapp.presenter.ui.movielist

import androidx.lifecycle.LiveData
import com.example.movieapp.presenter.common.utils.SingleLiveEvent
import com.example.movieapp.presenter.model.movie.Movie

interface MovieListContract {

    interface ViewModel {

        fun fetchMoviePopular()

        fun observeViewState(): LiveData<ViewState>

        fun observeNavigate(): SingleLiveEvent<NavigateEvent>

        fun onMovieClick(movie: Movie)
    }

    data class ViewState(val movieList: List<Movie>)

    sealed class NavigateEvent {
        class NavigateMovieDetail(val movie: Movie) : NavigateEvent()
    }
}