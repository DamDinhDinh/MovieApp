package com.example.movieapp.presenter.mapper.review

import com.example.domain.model.review.ModelAuthorDetails
import com.example.movieapp.presenter.model.review.AuthorDetails

fun ModelAuthorDetails.toPresent(): AuthorDetails =
    AuthorDetails(avatarPath, name, rating, username)

fun AuthorDetails.toModel(): ModelAuthorDetails =
    ModelAuthorDetails(avatarPath, name, rating, username)

