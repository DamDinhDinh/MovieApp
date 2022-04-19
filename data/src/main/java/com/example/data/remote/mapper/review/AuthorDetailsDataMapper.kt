package com.example.data.remote.mapper.review

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.review.JsonAuthorDetails
import com.example.domain.model.review.ModelAuthorDetails

fun JsonAuthorDetails.toModel(): ModelAuthorDetails = ModelAuthorDetails(
    avatarPath = avatarPath ?: DEFAULT_STRING,
    name = name ?: DEFAULT_STRING,
    rating = rating ?: DEFAULT_INT,
    username = username ?: DEFAULT_STRING
)

fun ModelAuthorDetails.toJson(): JsonAuthorDetails = JsonAuthorDetails(
    avatarPath = avatarPath,
    name = name,
    rating = rating,
    username = username
)
