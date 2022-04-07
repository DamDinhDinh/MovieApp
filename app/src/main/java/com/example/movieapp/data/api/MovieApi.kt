package com.example.movieapp.data.api

import com.example.movieapp.data.entities.movie.JsonMovie
import com.example.movieapp.data.entities.moviepopular.JsonMoviePopularResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("/3/movie/{movie_id}")
    fun getDetail(@Path("movie_id") id: Int): Single<JsonMovie>

    @GET("/3/movie/popular")
    fun getPopular(): Single<JsonMoviePopularResponse>
}