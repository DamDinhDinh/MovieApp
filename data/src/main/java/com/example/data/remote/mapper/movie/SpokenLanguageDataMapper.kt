package com.example.data.remote.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.movie.JsonSpokenLanguage
import com.example.domain.model.movie.ModelSpokenLanguage

fun JsonSpokenLanguage.toModel() =
    ModelSpokenLanguage(iso6391 ?: DEFAULT_STRING, name ?: DEFAULT_STRING)

fun ModelSpokenLanguage.toJson() = JsonSpokenLanguage(iso6391, name)