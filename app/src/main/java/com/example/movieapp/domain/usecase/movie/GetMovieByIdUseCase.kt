package com.example.movieapp.domain.usecase.movie

import com.example.movieapp.data.source.MovieDataSource
import com.example.movieapp.domain.model.movie.ModelMovie
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject


class GetMovieByIdUseCase @Inject constructor(private val movieDataSource: MovieDataSource) {

    operator fun invoke(request: Request): Single<ModelMovie> {
        return movieDataSource.getDetail(request.id)
    }

    data class Request(val id: Int)
}