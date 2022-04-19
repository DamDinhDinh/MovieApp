package com.example.movieapp.presenter.model.review

import com.example.common.DefaultModelValue

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
) {
    //TODO: Add property to take advantage of this Model as Presenter Model
    val authorRating =
        if (authorDetails.rating != DefaultModelValue.DEFAULT_INT) authorDetails.rating.toString() else ""
}
