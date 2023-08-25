package com.example.movieapp.presenter.movielist

import com.example.movieapp.presenter.model.movie.Movie

interface MovieListContract {
    interface View {
        fun updateList(movieList: List<Movie>)
        fun setPresenter(presenter: Presenter)
    }

    interface Presenter {
        fun setView(view: View)
        fun fetchMoviePopular()
        fun destroy()
    }
}