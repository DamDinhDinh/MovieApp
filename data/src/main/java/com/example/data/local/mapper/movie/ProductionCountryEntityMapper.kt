package com.example.data.local.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.movie.JsonProductionCountry
import com.example.data.local.databasemodel.movie.EntityProductionCountry

fun JsonProductionCountry.toEntity() =
    EntityProductionCountry(iso31661 ?: DEFAULT_STRING, name ?: DEFAULT_STRING)

fun EntityProductionCountry.toJson() = JsonProductionCountry(iso31661, name)