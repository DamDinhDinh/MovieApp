package com.example.domain.usecase.movie

import com.example.domain.source.MovieDataSource
import com.example.domain.model.moviepopular.ModelMoviePopular
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val movieDataSource: MovieDataSource) {
    operator fun invoke(): Single<List<ModelMoviePopular>> {
        return movieDataSource.getPopular()
    }
}