package com.example.domain.model.review

import com.example.common.DefaultModelValue

data class ModelAuthorDetails(
    val avatarPath: String = DefaultModelValue.DEFAULT_STRING,
    val name: String = DefaultModelValue.DEFAULT_STRING,
    val rating: Int = DefaultModelValue.DEFAULT_INT,
    val username: String = DefaultModelValue.DEFAULT_STRING
)