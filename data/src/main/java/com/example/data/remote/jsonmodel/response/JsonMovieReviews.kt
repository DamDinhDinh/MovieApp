package com.example.data.remote.jsonmodel.response


import com.example.data.remote.jsonmodel.review.JsonReview
import com.google.gson.annotations.SerializedName

data class JsonMovieReviews(
    @SerializedName("id")
    val id: String?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<JsonReview>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)
