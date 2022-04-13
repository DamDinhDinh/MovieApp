package com.example.data.remote.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.movie.JsonProductionCompany
import com.example.data.local.databasemodel.movie.EntityProductionCompany

fun JsonProductionCompany.toModel() =
    EntityProductionCompany(
        id ?: DEFAULT_INT,
        logoPath ?: DEFAULT_STRING,
        name ?: DEFAULT_STRING,
        originCountry ?: DEFAULT_STRING
    )

fun EntityProductionCompany.toJson() = JsonProductionCompany(id, logoPath, name, originCountry)