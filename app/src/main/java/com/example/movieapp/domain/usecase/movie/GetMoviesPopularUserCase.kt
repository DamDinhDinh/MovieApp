package com.example.movieapp.domain.usecase.movie

import com.example.movieapp.data.source.MovieDataSource
import com.example.movieapp.domain.model.movie.ModelMovie
import com.example.movieapp.domain.model.moviepopular.ModelMoviePopular
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetMoviesPopularUserCase @Inject constructor(private val movieDataSource: MovieDataSource) {
    operator fun invoke(): Single<List<ModelMoviePopular>> {
        return movieDataSource.getPopular()
    }
}