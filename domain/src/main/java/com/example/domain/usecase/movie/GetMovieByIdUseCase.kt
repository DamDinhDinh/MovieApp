package com.example.domain.usecase.movie

import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val movieDataSource: MovieDataSource) {

    suspend operator fun invoke(request: Request): Flow<ModelMovie> {
        return movieDataSource.getDetail(request.id)
    }

    data class Request(val id: String)
}