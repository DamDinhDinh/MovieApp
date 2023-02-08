package com.example.domain.model.movie

import com.example.common.DefaultModelValue

data class ModelProductionCompany(
    val id: String = DefaultModelValue.DEFAULT_STRING,
    val logoPath: String = DefaultModelValue.DEFAULT_STRING,
    val name: String = DefaultModelValue.DEFAULT_STRING,
    val originCountry: String = DefaultModelValue.DEFAULT_STRING
)