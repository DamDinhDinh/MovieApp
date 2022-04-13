package com.example.domain.usecase.movie

import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val movieDataSource: MovieDataSource) {
    operator fun invoke(): Single<List<ModelMovie>> {
        return movieDataSource.getPopular()
    }
}