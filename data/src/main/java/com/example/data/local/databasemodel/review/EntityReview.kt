package com.example.data.local.databasemodel.review

data class EntityReview(
    val author: String,
    val authorDetails: EntityAuthorDetails,
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