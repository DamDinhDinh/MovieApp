package com.example.domain.model.movie

import com.example.common.DefaultModelValue

data class ModelProductionCountry(
    val iso31661: String = DefaultModelValue.DEFAULT_STRING,
    val name: String = DefaultModelValue.DEFAULT_STRING
)