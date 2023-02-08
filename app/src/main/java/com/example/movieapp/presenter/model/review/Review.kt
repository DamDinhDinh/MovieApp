package com.example.movieapp.presenter.model.review

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

data class Review(
    var author: String = DEFAULT_STRING,
    var authorDetails: AuthorDetails = AuthorDetails(),
    var content: String = DEFAULT_STRING,
    var createdAt: String = DEFAULT_STRING,
    var id: String = DEFAULT_STRING,
    var iso6391: String = DEFAULT_STRING,
    var mediaId: String = DEFAULT_STRING,
    var mediaTitle: String = DEFAULT_STRING,
    var mediaType: String = DEFAULT_STRING,
    var updatedAt: String = DEFAULT_STRING,
    var url: String = DEFAULT_STRING,
) {
    val createdAtDDMMYYYY =
        if (createdAt.isNotEmpty()) createdAt.substring(0, 10) else DEFAULT_STRING
}
