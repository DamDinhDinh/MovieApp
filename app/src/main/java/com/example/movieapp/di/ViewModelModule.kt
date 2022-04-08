package com.example.movieapp.di

import com.example.movieapp.presenter.moviedetail.MovieDetailContract
import com.example.movieapp.presenter.moviedetail.MovieDetailViewModel
import com.example.movieapp.presenter.moviepopularlist.MoviePopularListContract
import com.example.movieapp.presenter.moviepopularlist.MoviePopularListViewModel
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun getMoviePopularViewModel(viewModel: MoviePopularListViewModel): MoviePopularListContract.ViewModel


    @Binds
    fun getMovieDetailViewModel(viewModel: MovieDetailViewModel): MovieDetailContract.ViewModel
}