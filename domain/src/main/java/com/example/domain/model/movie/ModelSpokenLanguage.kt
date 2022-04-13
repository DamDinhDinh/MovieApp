package com.example.domain.model.movie

import com.example.common.DefaultModelValue

data class ModelSpokenLanguage(
    val iso6391: String = DefaultModelValue.DEFAULT_STRING,
    val name: String = DefaultModelValue.DEFAULT_STRING
)