package com.example.domain.model.review

data class ModelReview(
    val author: String,
    val authorDetails: ModelAuthorDetails,
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