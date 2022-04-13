package com.example.data.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.local.databasemodel.movie.EntityProductionCompany
import com.example.data.remote.jsonmodel.movie.JsonProductionCompany
import com.example.domain.model.movie.ModelProductionCompany


//from this
fun EntityProductionCompany.toJson() = JsonProductionCompany(id, logoPath, name, originCountry)

fun EntityProductionCompany.toModel() = ModelProductionCompany(id, logoPath, name, originCountry)

//other map to this
fun JsonProductionCompany.toEntity() =
    EntityProductionCompany(
        id ?: DEFAULT_INT,
        logoPath ?: DEFAULT_STRING,
        name ?: DEFAULT_STRING,
        originCountry ?: DEFAULT_STRING
    )

fun ModelProductionCompany.toEntity() =
    EntityProductionCompany(
        id,
        logoPath,
        name,
        originCountry
    )