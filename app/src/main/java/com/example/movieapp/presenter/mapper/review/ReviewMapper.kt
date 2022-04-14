package com.example.movieapp.presenter.mapper.movie

import com.example.domain.model.review.ModelReview
import com.example.movieapp.presenter.model.review.Review

fun ModelReview.toPresent(): Review =
    Review(
        author = author,
        authorDetails = authorDetails.toPresent(),
        content,
        createdAt,
        id,
        iso6391,
        mediaId,
        mediaTitle,
        mediaType,
        updatedAt,
        url
    )

fun Review.toModel(): ModelReview =
    ModelReview(
        author = author,
        authorDetails = authorDetails.toModel(),
        content,
        createdAt,
        id,
        iso6391,
        mediaId,
        mediaTitle,
        mediaType,
        updatedAt,
        url
    )
