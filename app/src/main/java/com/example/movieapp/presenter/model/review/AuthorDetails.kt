package com.example.movieapp.presenter.model.review

import com.example.common.DefaultModelValue
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.di.ConfigModule

data class AuthorDetails(
    val avatarPath: String = DEFAULT_STRING,
    val name: String = DEFAULT_STRING,
    val rating: Int = DEFAULT_INT,
    val username: String = DEFAULT_STRING,
) {
    val avatarPathFull =
        when {
            avatarPath.startsWith("/https://") -> avatarPath.substring(1, avatarPath.length)
            avatarPath.isNotEmpty() -> ConfigModule.getBaseImgUrl() + avatarPath
            else -> DEFAULT_STRING
        }

    val authorRating =
        if (rating != DefaultModelValue.DEFAULT_INT) rating.toString() else DEFAULT_STRING
}