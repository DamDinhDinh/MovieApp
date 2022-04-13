package com.example.domain.model.movie

import com.example.common.DefaultModelValue
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT

data class ModelGenre(
    val id: Int = DEFAULT_INT,
    val name: String = DefaultModelValue.DEFAULT_STRING
)