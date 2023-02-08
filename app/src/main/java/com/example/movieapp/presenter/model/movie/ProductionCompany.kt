package com.example.movieapp.presenter.model.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.di.ConfigModule

data class ProductionCompany(
    val id: String = DEFAULT_STRING,
    val logoPath: String = DEFAULT_STRING,
    val name: String = DEFAULT_STRING,
    val originCountry: String = DEFAULT_STRING
) {
    val logoPathFull =
        if (logoPath.isNotEmpty()) ConfigModule.getBaseImgUrl() + logoPath else DEFAULT_STRING
}