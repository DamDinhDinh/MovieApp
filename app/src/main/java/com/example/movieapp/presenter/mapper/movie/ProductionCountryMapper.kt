package com.example.movieapp.presenter.mapper.movie

import com.example.movieapp.domain.model.movie.ModelProductionCountry
import com.example.movieapp.presenter.model.movie.ProductionCountry

class ProductionCountryMapper

fun ProductionCountry.toModel() = ModelProductionCountry(iso31661, name)
fun ModelProductionCountry.toPresent() = ProductionCountry(iso31661, name)
