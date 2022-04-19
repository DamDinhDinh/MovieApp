package com.example.movieapp.presenter.model.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

data class Genre(
    val id: Int = DEFAULT_INT,
    val name: String = DEFAULT_STRING
)