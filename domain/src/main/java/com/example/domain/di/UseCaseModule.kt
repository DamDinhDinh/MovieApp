package com.example.domain.di

import com.example.domain.usecase.movie.GetMovieByIdUseCase
import com.example.domain.usecase.movie.GetMovieReviewsUseCase
import com.example.domain.usecase.movie.GetPopularMoviesUseCase
import com.example.domain.usecase.movie.SetRateMovieUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetMovieByIdUseCase(get()) }
    factory { GetMovieReviewsUseCase(get()) }
    factory { GetPopularMoviesUseCase(get()) }
    factory { SetRateMovieUseCase(get()) }
}