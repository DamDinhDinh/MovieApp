package com.example.domain.model.review

import com.example.common.DefaultModelValue

data class ModelReview(
    var author: String = DefaultModelValue.DEFAULT_STRING,
    var authorDetails: ModelAuthorDetails = ModelAuthorDetails(
        DefaultModelValue.DEFAULT_STRING,
        DefaultModelValue.DEFAULT_STRING,
        DefaultModelValue.DEFAULT_INT,
        DefaultModelValue.DEFAULT_STRING
    ),
    var content: String = DefaultModelValue.DEFAULT_STRING,
    var createdAt: String = DefaultModelValue.DEFAULT_STRING,
    var id: String = DefaultModelValue.DEFAULT_STRING,
    var iso6391: String = DefaultModelValue.DEFAULT_STRING,
    var mediaId: Int = DefaultModelValue.DEFAULT_INT,
    var mediaTitle: String = DefaultModelValue.DEFAULT_STRING,
    var mediaType: String = DefaultModelValue.DEFAULT_STRING,
    var updatedAt: String = DefaultModelValue.DEFAULT_STRING,
    var url: String = DefaultModelValue.DEFAULT_STRING,
)