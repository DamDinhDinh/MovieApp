package com.example.domain.usecase.movie

import com.example.domain.model.ModelResponseStatus
import com.example.domain.source.MovieDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SetRateMovieUseCase @Inject constructor(private val movieDataSource: MovieDataSource) {
    suspend operator fun invoke(request: Request): Flow<ModelResponseStatus> {
        return movieDataSource.rateMovie(request.id, request.rate)
    }

    data class Request(val id: Int, val rate: Double)
}