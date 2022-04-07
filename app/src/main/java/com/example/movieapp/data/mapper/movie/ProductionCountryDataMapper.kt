package com.example.movieapp.data.mapper.movie

import com.example.movieapp.data.entities.movie.JsonProductionCountry
import com.example.movieapp.domain.model.movie.ModelProductionCountry

class ProductionCountryMapper

fun JsonProductionCountry.toModel() = ModelProductionCountry(iso31661, name)

fun ModelProductionCountry.toJson() = JsonProductionCountry(iso31661, name)