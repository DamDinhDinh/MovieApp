package com.example.data.local.mapper.review

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.review.JsonReview
import com.example.data.local.databasemodel.review.EntityAuthorDetails
import com.example.data.local.databasemodel.review.EntityReview
import com.example.data.local.mapper.review.toEntity
import com.example.data.local.mapper.review.toJson

fun JsonReview.toEntity(): EntityReview = EntityReview(
    author = author ?: DEFAULT_STRING,
    authorDetails = authorDetails?.toEntity() ?: EntityAuthorDetails(
        name = DEFAULT_STRING,
        avatarPath = DEFAULT_STRING,
        rating = DEFAULT_INT,
        username = DEFAULT_STRING
    ),
    content = content ?: DEFAULT_STRING,
    createdAt = createdAt ?: DEFAULT_STRING,
    id = id ?: DEFAULT_STRING,
    iso6391 = iso6391 ?: DEFAULT_STRING,
    mediaId = mediaId ?: DEFAULT_INT,
    mediaTitle = mediaTitle ?: DEFAULT_STRING,
    mediaType = mediaType ?: DEFAULT_STRING,
    updatedAt = updatedAt ?: DEFAULT_STRING,
    url = url ?: DEFAULT_STRING,
)

fun EntityReview.toJson() = JsonReview(
    author = author,
    authorDetails = authorDetails.toJson(),
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