package com.example.movieapp.presenter.model.review

data class Review(
    val author: String,
    val authorDetails: AuthorDetails,
    val content: String,
    val createdAt: String,
    val id: String,
    val iso6391: String,
    val mediaId: Int,
    val mediaTitle: String,
    val mediaType: String,
    val updatedAt: String,
    val url: String
)