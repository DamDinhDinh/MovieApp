package com.example.domain.usecase.movie

import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val movieDataSource: MovieDataSource) {
    suspend operator fun invoke(): Flow<List<ModelMovie>> {
        return movieDataSource.getPopular()
    }
}