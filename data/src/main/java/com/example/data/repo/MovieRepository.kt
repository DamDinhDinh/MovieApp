package com.example.data.repo

import com.example.data.remote.api.MovieApi
import com.example.data.remote.mapper.movie.toModel
import com.example.data.remote.mapper.moviepopular.toModel
import com.example.data.remote.mapper.toModel
import com.example.domain.model.ModelResponseStatus
import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApi: MovieApi) : MovieDataSource {
    override suspend fun getDetail(id: Int): Flow<ModelMovie> = flow {
        emit(movieApi.getDetail(id).toModel())
    }

    override suspend fun getPopular(): Flow<List<ModelMovie>> = flow {
        emit(movieApi.getPopular().results?.map { movie -> movie.toModel() } ?: listOf())
    }

    override suspend fun rateMovie(id: Int, rate: Double): Flow<ModelResponseStatus> = flow {
        val paramsMap = hashMapOf<String, Any>()
        paramsMap["values"] = rate
        emit(movieApi.setRateMovie(id, paramsMap).toModel())
    }
}