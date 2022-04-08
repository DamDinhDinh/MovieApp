package com.example.movieapp.data.repo

import com.example.movieapp.data.api.MovieApi
import com.example.movieapp.data.mapper.movie.toModel
import com.example.movieapp.data.mapper.moviepopular.toModel
import com.example.movieapp.data.mapper.toModel
import com.example.movieapp.data.source.MovieDataSource
import com.example.movieapp.domain.model.ModelResponseStatus
import com.example.movieapp.domain.model.movie.ModelMovie
import com.example.movieapp.domain.model.moviepopular.ModelMoviePopular
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