package com.example.movieapp.di

import com.example.movieapp.presenter.movielist.MovieListContract
import com.example.movieapp.presenter.movielist.MovieListPresenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class PresenterModule {

    @Binds
    abstract fun getMovieListPresenter(movieListPresenter: MovieListPresenter): MovieListContract.Presenter
}