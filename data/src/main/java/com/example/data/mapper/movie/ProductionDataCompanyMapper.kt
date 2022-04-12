package com.example.data.mapper.movie

import com.example.data.jsonmodel.movie.JsonProductionCompany
import com.example.domain.model.movie.ModelProductionCompany

fun JsonProductionCompany.toModel() = ModelProductionCompany(id, logoPath, name, originCountry)

fun ModelProductionCompany.toJson() = JsonProductionCompany(id, logoPath, name, originCountry)