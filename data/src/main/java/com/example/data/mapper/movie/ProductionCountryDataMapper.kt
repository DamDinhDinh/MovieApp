package com.example.data.mapper.movie

import com.example.data.jsonmodel.movie.JsonProductionCountry
import com.example.domain.model.movie.ModelProductionCountry

fun JsonProductionCountry.toModel() = ModelProductionCountry(iso31661, name)

fun ModelProductionCountry.toJson() = JsonProductionCountry(iso31661, name)