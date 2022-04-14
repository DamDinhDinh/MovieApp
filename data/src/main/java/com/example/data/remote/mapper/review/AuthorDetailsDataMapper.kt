package com.example.data.remote.mapper.review

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.di.ConfigModule
import com.example.data.remote.jsonmodel.review.JsonAuthorDetails
import com.example.data.local.databasemodel.review.EntityAuthorDetails
import com.example.domain.model.review.ModelAuthorDetails

fun JsonAuthorDetails.toModel(): ModelAuthorDetails = ModelAuthorDetails(
    avatarPath = when {
        !avatarPath.isNullOrEmpty() -> ConfigModule.getBaseImgUrl() + avatarPath
        else -> DEFAULT_STRING
    },
    name = name ?: DEFAULT_STRING,
    rating = rating ?: DEFAULT_INT,
    username = username ?: DEFAULT_STRING
)

fun ModelAuthorDetails.toJson(): JsonAuthorDetails = JsonAuthorDetails(
    avatarPath = when {
        !avatarPath.isNullOrEmpty() -> avatarPath.removePrefix(ConfigModule.getBaseImgUrl())
        else -> avatarPath
    },
    name = name,
    rating = rating,
    username = username
)