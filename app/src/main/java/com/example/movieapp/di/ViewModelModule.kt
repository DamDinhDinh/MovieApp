package com.example.movieapp.di

import com.example.movieapp.presenter.moviepopularlist.MoviePopularListContract
import com.example.movieapp.presenter.moviepopularlist.MoviePopularListViewModel
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun getMoviePopularViewModel(moviePopularListViewModel: MoviePopularListViewModel): MoviePopularListContract.ViewModel
}