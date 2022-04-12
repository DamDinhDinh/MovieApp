package com.example.data.mapper.movie

import com.example.data.jsonmodel.movie.JsonSpokenLanguage
import com.example.domain.model.movie.ModelSpokenLanguage

fun JsonSpokenLanguage.toModel() = ModelSpokenLanguage(iso6391, name)

fun ModelSpokenLanguage.toJson() = JsonSpokenLanguage(iso6391, name)