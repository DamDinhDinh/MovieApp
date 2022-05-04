package com.example.data.di

import com.example.data.repo.MovieRepository
import com.example.data.repo.ReviewRepository
import com.example.domain.source.MovieDataSource
import com.example.domain.source.ReviewDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun getMovieDataSource(moveRepo: MovieRepository): MovieDataSource

    @Binds
    abstract fun getReviewDataSource(reviewRepo: ReviewRepository): ReviewDataSource
}