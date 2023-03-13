package com.example.data.repo

import com.example.data.local.mapper.movie.toEntity
import com.example.data.local.mapper.movie.toModel
import com.example.data.local.roomdatabase.dao.MovieDao
import com.example.data.remote.api.MovieApi
import com.example.data.remote.mapper.moviepopular.toEntity
import com.example.data.remote.mapper.toModel
import com.example.domain.model.ModelResponseStatus
import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao,
) : MovieDataSource {
    override suspend fun getDetail(id: String): Flow<ModelMovie> {
        fetchMovieDetail(id)
        return movieDao.getMovieById(id).map { it.toModel() }
    }

    private suspend fun fetchMovieDetail(id: String) {
        movieDao.insert(listOf(movieApi.getDetail(id).toEntity()))
    }

    override suspend fun getPopular(): Flow<List<ModelMovie>> {
        fetchPopularMovies()
        return movieDao.getPopularMovie().map { movies -> movies.map { it.toModel() } }
    }

    private suspend fun fetchPopularMovies() {
        movieApi.getPopular().results?.map { movie -> movie.toEntity() }
            ?.let { movieDao.insert(it) }
    }

    override suspend fun rateMovie(id: String, rate: Double): Flow<ModelResponseStatus> = flow {
        val paramsMap = hashMapOf<String, Any>()
        paramsMap["values"] = rate
        emit(movieApi.setRateMovie(id, paramsMap).toModel())
    }
}