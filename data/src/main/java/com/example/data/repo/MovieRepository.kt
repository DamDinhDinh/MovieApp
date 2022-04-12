package com.example.data.repo

import com.example.data.api.MovieApi
import com.example.data.mapper.movie.toModel
import com.example.data.mapper.moviepopular.toModel
import com.example.data.mapper.toModel
import com.example.domain.source.MovieDataSource
import com.example.domain.model.ModelResponseStatus
import com.example.domain.model.movie.ModelMovie
import com.example.domain.model.moviepopular.ModelMoviePopular
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieApi: MovieApi) : MovieDataSource {

    private val TAG = "MovieRepository"
    override fun getDetail(id: Int): Single<ModelMovie> {
        return movieApi.getDetail(id)
            .doOnEvent { list, error ->
                println("$TAG getDetail $list")
                println("$TAG getDetail $error")
            }.map { it.toModel() }
    }

    override fun getPopular(): Single<List<ModelMoviePopular>> {
        return movieApi.getPopular()
            .doOnEvent { list, error ->
                println("$TAG getPopular $list")
                println("$TAG getPopular $error")
            }
            .map { response -> response.results.map { it.toModel() } }
    }

    override fun rateMovie(id: Int, rate: Double): Single<ModelResponseStatus> {
        val paramsMap = hashMapOf<String, Any>()
        paramsMap["values"] = rate
        return movieApi.setRateMovie(id, paramsMap).doOnEvent { list, error ->
            println("$TAG rateMovie $list")
            println("$TAG rateMovie $error")
        }.map { it.toModel() }
    }
}
