package com.example.movieapp.data.mapper.movie

import com.example.movieapp.data.entities.movie.JsonProductionCompany
import com.example.movieapp.domain.model.movie.ModelProductionCompany

class ProductionCompanyMapper

fun JsonProductionCompany.toModel() = ModelProductionCompany(id, logoPath, name, originCountry)

fun ModelProductionCompany.toJson() = JsonProductionCompany(id, logoPath, name, originCountry)