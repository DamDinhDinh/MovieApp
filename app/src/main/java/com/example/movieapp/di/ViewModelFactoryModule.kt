package com.example.movieapp.di

import com.example.movieapp.presenter.moviedetail.MovieDetailViewModel
import com.example.movieapp.presenter.movielist.MovieListViewModel
import dagger.Module

@Module
interface ViewModelFactoryModule {

    fun getMoviePopularViewModelFactory(): MovieListViewModel.Factory


    fun getMovieDetailViewModelFactory(): MovieDetailViewModel.Factory
}