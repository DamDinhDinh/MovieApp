package com.example.data.di

import com.example.data.repo.MovieRepository
import com.example.data.repo.ReviewRepository
import com.example.domain.source.MovieDataSource
import com.example.domain.source.ReviewDataSource
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun getMovieDataSource(moveRepo: MovieRepository): MovieDataSource

    @Binds
    fun getReviewDataSource(reviewRepo: ReviewRepository): ReviewDataSource
}