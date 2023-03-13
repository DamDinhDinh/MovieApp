package com.example.movieapp.presenter.ui.movielist

import com.example.movieapp.presenter.model.movie.Movie
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface MovieListContract {

    interface ViewModel {

        fun fetchMoviePopular()

        fun observeViewState(): StateFlow<ViewState?>

        fun observeNavigate(): SharedFlow<NavigateEvent>

        fun onMovieClick(movie: Movie)
    }

    data class ViewState(val movieList: List<Movie>)

    sealed class NavigateEvent {
        class NavigateMovieDetail(val movie: Movie) : NavigateEvent()
    }
}