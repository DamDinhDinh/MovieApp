package com.example.data.remote.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_BOOLEAN
import com.example.common.DefaultModelValue.Companion.DEFAULT_DOUBLE
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.di.ConfigModule
import com.example.data.remote.jsonmodel.movie.JsonMovie
import com.example.domain.model.movie.ModelMovie

fun JsonMovie.toModel() = ModelMovie(
    adult = adult ?: DEFAULT_BOOLEAN,
    backdropPath = if (!backdropPath.isNullOrEmpty()) ConfigModule.getBaseImgUrl() + backdropPath else DEFAULT_STRING,
    belongsToCollection = belongsToCollection ?: Any(),
    budget = budget ?: DEFAULT_INT,
    genres = genres?.map { it.toModel() } ?: listOf(),
    genreIds = genres?.map { it.id!! } ?: listOf(),
    homepage = homepage ?: DEFAULT_STRING,
    id = id ?: DEFAULT_INT,
    imdbId = imdbId ?: DEFAULT_STRING,
    originalLanguage = originalLanguage ?: DEFAULT_STRING,
    originalTitle = originalTitle ?: DEFAULT_STRING,
    overview = overview ?: DEFAULT_STRING,
    popularity = popularity ?: DEFAULT_DOUBLE,
    posterPath = if (!posterPath.isNullOrEmpty()) ConfigModule.getBaseImgUrl() + posterPath else DEFAULT_STRING,
    productionCompanies = productionCompanies?.map { it.toModel() } ?: listOf(),
    productionCountries = productionCountries?.map { it.toModel() } ?: listOf(),
    releaseDate = releaseDate ?: DEFAULT_STRING,
    revenue = revenue ?: DEFAULT_INT,
    runtime = runtime ?: DEFAULT_INT,
    spokenLanguages = spokenLanguages?.map { it.toModel() } ?: listOf(),
    status = status ?: DEFAULT_STRING,
    tagline = tagline ?: DEFAULT_STRING,
    title = title ?: DEFAULT_STRING,
    video = video ?: DEFAULT_BOOLEAN,
    voteAverage = voteAverage ?: DEFAULT_DOUBLE,
    voteCount = voteCount ?: DEFAULT_INT
)

fun ModelMovie.toJson() = JsonMovie(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = belongsToCollection,
    budget = budget,
    genres = genres.map { it.toJson() },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies.map { it.toJson() },
    productionCountries = productionCountries.map { it.toJson() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.toJson() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

