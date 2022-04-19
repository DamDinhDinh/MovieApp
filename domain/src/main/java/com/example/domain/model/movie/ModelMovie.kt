package com.example.domain.model.movie

import com.example.common.DefaultModelValue

data class ModelMovie(
    val adult: Boolean = DefaultModelValue.DEFAULT_BOOLEAN,
    val backdropPath: String = DefaultModelValue.DEFAULT_STRING,
    val belongsToCollection: Any = DefaultModelValue.DEFAULT_STRING,
    val budget: Int = DefaultModelValue.DEFAULT_INT,
    val genres: List<ModelGenre> = listOf(),
    val genreIds: List<Int> = listOf(),
    val homepage: String = DefaultModelValue.DEFAULT_STRING,
    val id: Int = DefaultModelValue.DEFAULT_INT,
    val imdbId: String = DefaultModelValue.DEFAULT_STRING,
    val originalLanguage: String = DefaultModelValue.DEFAULT_STRING,
    val originalTitle: String = DefaultModelValue.DEFAULT_STRING,
    val overview: String = DefaultModelValue.DEFAULT_STRING,
    val popularity: Double = DefaultModelValue.DEFAULT_DOUBLE,
    val posterPath: String = DefaultModelValue.DEFAULT_STRING,
    val productionCompanies: List<ModelProductionCompany> = listOf(),
    val productionCountries: List<ModelProductionCountry> = listOf(),
    val releaseDate: String = DefaultModelValue.DEFAULT_STRING,
    val revenue: Int = DefaultModelValue.DEFAULT_INT,
    val runtime: Int = DefaultModelValue.DEFAULT_INT,
    val spokenLanguages: List<ModelSpokenLanguage> = listOf(),
    val status: String = DefaultModelValue.DEFAULT_STRING,
    val tagline: String = DefaultModelValue.DEFAULT_STRING,
    val title: String = DefaultModelValue.DEFAULT_STRING,
    val video: Boolean = DefaultModelValue.DEFAULT_BOOLEAN,
    val voteAverage: Double = DefaultModelValue.DEFAULT_DOUBLE,
    val voteCount: Int = DefaultModelValue.DEFAULT_INT
)