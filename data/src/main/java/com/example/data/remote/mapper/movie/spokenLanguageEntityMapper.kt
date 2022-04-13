package com.example.data.remote.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.movie.JsonSpokenLanguage
import com.example.data.local.databasemodel.movie.EntitySpokenLanguage

fun JsonSpokenLanguage.toModel() =
    EntitySpokenLanguage(iso6391 ?: DEFAULT_STRING, name ?: DEFAULT_STRING)

fun EntitySpokenLanguage.toJson() = JsonSpokenLanguage(iso6391, name)