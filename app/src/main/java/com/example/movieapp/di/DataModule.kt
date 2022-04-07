package com.example.movieapp.di

import com.example.movieapp.data.repo.MovieRepository
import com.example.movieapp.data.source.MovieDataSource
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun getMovieDataSource(repo: MovieRepository): MovieDataSource
}