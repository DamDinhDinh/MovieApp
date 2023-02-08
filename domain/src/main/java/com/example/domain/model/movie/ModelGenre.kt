package com.example.domain.model.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

data class ModelGenre(
    val id: String = DEFAULT_STRING,
    val name: String = DEFAULT_STRING
)