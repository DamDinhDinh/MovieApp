package com.example.data.local.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.local.databasemodel.movie.EntitySpokenLanguage
import com.example.data.remote.jsonmodel.movie.JsonSpokenLanguage
import com.example.domain.model.movie.ModelSpokenLanguage

//from this
fun EntitySpokenLanguage.toJson() = JsonSpokenLanguage(iso6391, name)

fun EntitySpokenLanguage.toModel() = ModelSpokenLanguage(iso6391, name)


//other map to this
fun JsonSpokenLanguage.toEntity() =
    EntitySpokenLanguage(iso6391 ?: DEFAULT_STRING, name ?: DEFAULT_STRING)

fun ModelSpokenLanguage.toEntity() =
    EntitySpokenLanguage(iso6391, name)