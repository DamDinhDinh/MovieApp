package com.example.data.remote.api

import com.example.data.remote.jsonmodel.response.JsonMovieReviews
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewApi {

    @GET("/3/movie/{movie_id}/reviews")
    suspend fun getReviewsOfMovie(@Path("movie_id") id: Int): JsonMovieReviews
}