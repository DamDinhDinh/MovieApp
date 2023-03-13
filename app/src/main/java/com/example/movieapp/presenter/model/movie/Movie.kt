package com.example.movieapp.presenter.model.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_BOOLEAN
import com.example.common.DefaultModelValue.Companion.DEFAULT_DOUBLE
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.di.ConfigModule
import java.math.BigDecimal

data class Movie(
    val adult: Boolean = DEFAULT_BOOLEAN,
    val backdropPath: String = DEFAULT_STRING,
    val belongsToCollection: Any = DEFAULT_STRING,
    val budget: Int = DEFAULT_INT,
    val genres: List<Genre> = listOf(),
    val genreIds: List<Int> = listOf(),
    val homepage: String = DEFAULT_STRING,
    val id: String = DEFAULT_STRING,
    val imdbId: String = DEFAULT_STRING,
    val originalLanguage: String = DEFAULT_STRING,
    val originalTitle: String = DEFAULT_STRING,
    val overview: String = DEFAULT_STRING,
    val popularity: Double = DEFAULT_DOUBLE,
    val posterPath: String = DEFAULT_STRING,
    val productionCompanies: List<ProductionCompany> = listOf(),
    val productionCountries: List<ProductionCountry> = listOf(),
    val releaseDate: String = DEFAULT_STRING,
    val revenue: BigDecimal = BigDecimal.ZERO,
    val runtime: Int = DEFAULT_INT,
    val spokenLanguages: List<SpokenLanguage> = listOf(),
    val status: String = DEFAULT_STRING,
    val tagline: String = DEFAULT_STRING,
    val title: String = DEFAULT_STRING,
    val video: Boolean = DEFAULT_BOOLEAN,
    val voteAverage: Double = DEFAULT_DOUBLE,
    val voteCount: Int = DEFAULT_INT
) {
    val backdropPathFull =
        if (backdropPath.isNotEmpty()) ConfigModule.getBaseImgUrl() + backdropPath else DEFAULT_STRING

    val posterPathFull =
        if (posterPath.isNotEmpty()) ConfigModule.getBaseImgUrl() + posterPath else DEFAULT_STRING
}