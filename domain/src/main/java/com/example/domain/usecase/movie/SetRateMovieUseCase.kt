package com.example.domain.usecase.movie

import com.example.domain.model.ModelResponseStatus
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Single

class SetRateMovieUseCase constructor(private val movieDataSource: MovieDataSource) {
    operator fun invoke(request: Request): Single<ModelResponseStatus> {
        return movieDataSource.rateMovie(request.id, request.rate)
    }

    data class Request(val id: Int, val rate: Double)
}