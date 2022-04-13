package com.example.data.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.local.databasemodel.movie.EntityProductionCountry
import com.example.data.remote.jsonmodel.movie.JsonProductionCountry
import com.example.domain.model.movie.ModelProductionCountry

//from this
fun EntityProductionCountry.toJson() = JsonProductionCountry(iso31661, name)

fun EntityProductionCountry.toModel() = ModelProductionCountry(iso31661, name)


//other map to this
fun JsonProductionCountry.toEntity() =
    EntityProductionCountry(iso31661 ?: DEFAULT_STRING, name ?: DEFAULT_STRING)

fun ModelProductionCountry.toEntity() =
    EntityProductionCountry(iso31661, name)

