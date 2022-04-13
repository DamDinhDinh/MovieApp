package com.example.data.remote.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.movie.JsonProductionCountry
import com.example.domain.model.movie.ModelProductionCountry

fun JsonProductionCountry.toModel() =
    ModelProductionCountry(iso31661 ?: DEFAULT_STRING, name ?: DEFAULT_STRING)

fun ModelProductionCountry.toJson() = JsonProductionCountry(iso31661, name)