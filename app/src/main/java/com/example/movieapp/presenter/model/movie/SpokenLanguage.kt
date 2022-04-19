package com.example.movieapp.presenter.model.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

data class SpokenLanguage(
    val iso6391: String = DEFAULT_STRING,
    val name: String = DEFAULT_STRING
)