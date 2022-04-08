package com.example.movieapp.data.api

import com.example.movieapp.data.entities.JsonResponseStatus
import com.example.movieapp.data.entities.movie.JsonMovie
import com.example.movieapp.data.entities.moviepopular.JsonMoviePopularResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieApi {

    @GET("/3/movie/{movie_id}")
    fun getDetail(@Path("movie_id") id: Int): Single<JsonMovie>

    @GET("/3/movie/popular")
    fun getPopular(): Single<JsonMoviePopularResponse>

    @POST("/movie/{movie_id}/rating")
    fun setRateMovie(
        @Path("movie_id") id: Int,
        @Body params: HashMap<String, Any>
    ): Single<JsonResponseStatus>
}