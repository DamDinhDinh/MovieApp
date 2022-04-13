package com.example.data.remote.api

import com.example.data.remote.jsonmodel.response.JsonMovieReviews
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewApi {

    @GET("/3/movie/{movie_id}/reviews")
    fun getReviewsOfMovie(@Path("movie_id") id: Int): Single<JsonMovieReviews>
}