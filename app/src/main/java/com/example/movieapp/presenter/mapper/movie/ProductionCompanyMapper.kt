package com.example.movieapp.presenter.mapper.movie

import com.example.movieapp.domain.model.movie.ModelProductionCompany
import com.example.movieapp.presenter.model.movie.ProductionCompany

class ProductionCompanyMapper

fun ProductionCompany.toModel() = ModelProductionCompany(id, logoPath, name, originCountry)

fun ModelProductionCompany.toPresent() = ProductionCompany(id, logoPath, name, originCountry)