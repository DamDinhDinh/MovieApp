package com.example.data.local.mapper.review

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.di.ConfigModule
import com.example.data.local.databasemodel.review.EntityAuthorDetails
import com.example.data.remote.jsonmodel.review.JsonAuthorDetails
import com.example.domain.model.review.ModelAuthorDetails

//from this
fun EntityAuthorDetails.toJson() = JsonAuthorDetails(
    avatarPath = when {
        avatarPath.isNotEmpty() -> avatarPath.removePrefix(ConfigModule.getBaseImgUrl())
        else -> avatarPath
    },
    name = name,
    rating = rating,
    username = username
)

fun EntityAuthorDetails.toModel() = ModelAuthorDetails(
    avatarPath = when {
        avatarPath.isNotEmpty() -> avatarPath.removePrefix(ConfigModule.getBaseImgUrl())
        else -> avatarPath
    },
    name = name,
    rating = rating,
    username = username
)

//other map to this
fun JsonAuthorDetails.toEntity(): EntityAuthorDetails = EntityAuthorDetails(
    avatarPath = when {
        !avatarPath.isNullOrEmpty() -> ConfigModule.getBaseImgUrl() + avatarPath
        else -> DEFAULT_STRING
    },
    name = name ?: DEFAULT_STRING,
    rating = rating ?: DEFAULT_INT,
    username = username ?: DEFAULT_STRING
)

fun ModelAuthorDetails.toEntity(): EntityAuthorDetails = EntityAuthorDetails(
    avatarPath = when {
        avatarPath.isNotEmpty() -> ConfigModule.getBaseImgUrl() + avatarPath
        else -> DEFAULT_STRING
    },
    name = name,
    rating = rating,
    username = username
)

