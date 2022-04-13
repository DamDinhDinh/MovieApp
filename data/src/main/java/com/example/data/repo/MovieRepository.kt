package com.example.data.repo

import com.example.common.logs
import com.example.data.remote.api.MovieApi
import com.example.data.remote.mapper.movie.toModel
import com.example.data.remote.mapper.moviepopular.toModel
import com.example.data.remote.mapper.review.toModel
import com.example.data.remote.mapper.toModel
import com.example.domain.model.ModelResponseStatus
import com.example.data.local.databasemodel.movie.EntityMovie
import com.example.domain.model.moviepopular.ModelMoviePopular
import com.example.data.local.databasemodel.review.EntityReview
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApi: MovieApi) : MovieDataSource {

    companion object {
        private val TAG = MovieRepository::class.simpleName
    }

    override fun getDetail(id: Int): Single<EntityMovie> {
        return movieApi.getDetail(id)
            .logs("$TAG getDetail")
            .map { it.toModel() }
    }

    override fun getPopular(): Single<List<ModelMoviePopular>> {
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

    override fun getReviews(id: Int): Single<List<EntityReview>> {
        return movieApi.getReviews(id)
            .logs("$TAG getReviews")
            .map { response ->
                if (!response.results.isNullOrEmpty()) response.results.map { it.toModel() } else listOf()
            }

    }
}
