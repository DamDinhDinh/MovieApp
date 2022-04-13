package com.example.data.remote.di

import com.example.data.repo.MovieRepository
import com.example.domain.source.MovieDataSource
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun getMovieDataSource(repo: MovieRepository): MovieDataSource
}