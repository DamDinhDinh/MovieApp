package com.example.data.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.jsonmodel.movie.JsonProductionCompany
import com.example.domain.model.movie.ModelProductionCompany

fun JsonProductionCompany.toModel() =
    ModelProductionCompany(
        id ?: DEFAULT_INT,
        logoPath ?: DEFAULT_STRING,
        name ?: DEFAULT_STRING,
        originCountry ?: DEFAULT_STRING
    )

fun ModelProductionCompany.toJson() = JsonProductionCompany(id, logoPath, name, originCountry)