package com.example.domain.usecase.movie

import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable

class GetPopularMoviesUseCase constructor(private val movieDataSource: MovieDataSource) {
    operator fun invoke(): Observable<List<ModelMovie>> {
        return movieDataSource.getPopular()
    }
}