package com.example.movieapp.presenter.mapper.movie

import com.example.domain.model.movie.ModelProductionCountry
import com.example.movieapp.presenter.model.movie.ProductionCountry

fun ProductionCountry.toModel() = ModelProductionCountry(iso31661, name)
fun ModelProductionCountry.toPresent() = ProductionCountry(iso31661, name)
