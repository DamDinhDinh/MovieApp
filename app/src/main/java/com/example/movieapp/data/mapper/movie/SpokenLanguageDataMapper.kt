package com.example.movieapp.data.mapper.movie

import com.example.movieapp.data.entities.movie.JsonSpokenLanguage
import com.example.movieapp.domain.model.movie.ModelSpokenLanguage

fun JsonSpokenLanguage.toModel() = ModelSpokenLanguage(iso6391, name)

fun ModelSpokenLanguage.toJson() = JsonSpokenLanguage(iso6391, name)