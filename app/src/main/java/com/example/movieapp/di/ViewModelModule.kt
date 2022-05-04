package com.example.movieapp.di

import com.example.movieapp.presenter.moviedetail.MovieDetailViewModel
import com.example.movieapp.presenter.moviedetail.MovieReviewsViewModel
import com.example.movieapp.presenter.movielist.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { MovieListViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
    viewModel { MovieReviewsViewModel(get()) }
}