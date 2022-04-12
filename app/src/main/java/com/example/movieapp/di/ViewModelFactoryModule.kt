package com.example.movieapp.di

import com.example.movieapp.presenter.moviedetail.MovieDetailViewModel
import com.example.movieapp.presenter.moviepopularlist.MoviePopularListViewModel
import dagger.Module

@Module
interface ViewModelFactoryModule {

    fun getMoviePopularViewModelFactory(): MoviePopularListViewModel.Factory


    fun getMovieDetailViewModelFactory(): MovieDetailViewModel.Factory
}