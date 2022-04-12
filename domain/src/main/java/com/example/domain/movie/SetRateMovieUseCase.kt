package com.example.domain.movie

import com.example.domain.source.MovieDataSource
import com.example.domain.model.ModelResponseStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SetRateMovieUseCase @Inject constructor(private val movieDataSource: MovieDataSource) {
    operator fun invoke(request: Request): Single<ModelResponseStatus> {
        return movieDataSource.rateMovie(request.id, request.rate)
    }

    data class Request(val id: Int, val rate: Double)
}