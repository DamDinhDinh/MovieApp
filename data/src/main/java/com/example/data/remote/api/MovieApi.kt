package com.example.data.remote.api

import com.example.data.remote.jsonmodel.JsonResponseStatus
import com.example.data.remote.jsonmodel.movie.JsonMovie
import com.example.data.remote.jsonmodel.response.JsonMovieReviews
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