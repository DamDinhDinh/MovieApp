package com.example.data.repo

import com.example.common.logs
import com.example.data.local.databasemodel.roomdatabase.dao.MovieDao
import com.example.data.remote.api.MovieApi
import com.example.data.remote.mapper.movie.toModel
import com.example.data.remote.mapper.moviepopular.toModel
import com.example.data.remote.mapper.toModel
import com.example.domain.model.ModelResponseStatus
import com.example.domain.model.movie.ModelMovie
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDao: MovieDao
) : MovieDataSource {

    companion object {
        private val TAG = MovieRepository::class.simpleName
    }

    override fun getDetail(id: Int): Single<ModelMovie> {
        return movieApi.getDetail(id)
            .logs("$TAG getDetail")
            .map { it.toModel() }
    }

    override fun getPopular(): Single<List<ModelMovie>> {
        return movieApi.getPopular()
            .logs("$TAG getPopular")
            .map { response ->
                if (!response.results.isNullOrEmpty()) response.results.map { it.toModel() } else listOf()
            }
    }

    override fun rateMovie(id: Int, rate: Double): Single<ModelResponseStatus> {
        val paramsMap = hashMapOf<String, Any>()
        paramsMap["values"] = rate
        return movieApi.setRateMovie(id, paramsMap)
            .logs("$TAG rateMovie")
            .map { it.toModel() }
    }
}
