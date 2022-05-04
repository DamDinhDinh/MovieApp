package com.example.data.di

import com.example.data.repo.MovieRepository
import com.example.data.repo.ReviewRepository
import com.example.domain.source.MovieDataSource
import com.example.domain.source.ReviewDataSource
import org.koin.dsl.bind
import org.koin.dsl.module

val repoModule = module {
    factory { MovieRepository(get(), get()) } bind MovieDataSource::class
    factory { ReviewRepository(get(), get()) } bind ReviewDataSource::class
}