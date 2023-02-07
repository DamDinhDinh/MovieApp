package com.example.data.remote.api

import com.example.data.remote.jsonmodel.JsonResponseStatus
import com.example.data.remote.jsonmodel.movie.JsonMovie
import com.example.movieapp.data.entities.moviepopular.JsonMoviePopularResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieApi {

    @GET("/3/movie/{movie_id}")
    suspend fun getDetail(@Path("movie_id") id: Int): JsonMovie

    @GET("/3/movie/popular")
    suspend fun getPopular(): JsonMoviePopularResponse

    @POST("/movie/{movie_id}/rating")
    suspend fun setRateMovie(
        @Path("movie_id") id: Int,
        @Body params: HashMap<String, Any>
    ): JsonResponseStatus
}