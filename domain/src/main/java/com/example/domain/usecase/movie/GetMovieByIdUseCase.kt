package com.example.domain.usecase.movie

import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Observable


class GetMovieByIdUseCase constructor(private val movieDataSource: MovieDataSource) {

    operator fun invoke(request: Request): Observable<ModelMovie> {
        return movieDataSource.getDetail(request.id)
    }

    data class Request(val id: Int)
}