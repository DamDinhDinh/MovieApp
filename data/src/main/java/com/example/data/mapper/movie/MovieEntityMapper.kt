package com.example.data.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_BOOLEAN
import com.example.common.DefaultModelValue.Companion.DEFAULT_DOUBLE
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.di.ConfigModule
import com.example.data.local.databasemodel.movie.EntityMovie
import com.example.data.remote.jsonmodel.movie.JsonMovie
import com.example.domain.model.movie.ModelMovie

//from this
fun EntityMovie.toJson() = JsonMovie(
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

fun EntityMovie.toModel() = ModelMovie(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = belongsToCollection,
    budget = budget,
    genres = genres.map { it.toModel() },
    genreIds = genres.map { it.id },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies.map { it.toModel() },
    productionCountries = productionCountries.map { it.toModel() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.toModel() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

//other map to this
fun JsonMovie.toEntity() = EntityMovie(
    adult = adult ?: DEFAULT_BOOLEAN,
    backdropPath = if (!backdropPath.isNullOrEmpty()) ConfigModule.getBaseImgUrl() + backdropPath else DEFAULT_STRING,
    belongsToCollection = belongsToCollection ?: Any(),
    budget = budget ?: DEFAULT_INT,
    genres = genres?.map { it.toEntity() } ?: listOf(),
    homepage = homepage ?: DEFAULT_STRING,
    id = id ?: DEFAULT_INT,
    imdbId = imdbId ?: DEFAULT_STRING,
    originalLanguage = originalLanguage ?: DEFAULT_STRING,
    originalTitle = originalTitle ?: DEFAULT_STRING,
    overview = overview ?: DEFAULT_STRING,
    popularity = popularity ?: DEFAULT_DOUBLE,
    posterPath = if (!posterPath.isNullOrEmpty()) ConfigModule.getBaseImgUrl() + posterPath else DEFAULT_STRING,
    productionCompanies = productionCompanies?.map { it.toEntity() } ?: listOf(),
    productionCountries = productionCountries?.map { it.toEntity() } ?: listOf(),
    releaseDate = releaseDate ?: DEFAULT_STRING,
    revenue = revenue ?: DEFAULT_INT,
    runtime = runtime ?: DEFAULT_INT,
    spokenLanguages = spokenLanguages?.map { it.toEntity() } ?: listOf(),
    status = status ?: DEFAULT_STRING,
    tagline = tagline ?: DEFAULT_STRING,
    title = title ?: DEFAULT_STRING,
    video = video ?: DEFAULT_BOOLEAN,
    voteAverage = voteAverage ?: DEFAULT_DOUBLE,
    voteCount = voteCount ?: DEFAULT_INT
)

fun ModelMovie.toEntity() = EntityMovie(
    adult = adult,
    backdropPath = if (backdropPath.isNotEmpty()) ConfigModule.getBaseImgUrl() + backdropPath else DEFAULT_STRING,
    belongsToCollection = belongsToCollection,
    budget = budget,
    genres = genres.map { it.toEntity() },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = if (posterPath.isNotEmpty()) ConfigModule.getBaseImgUrl() + posterPath else DEFAULT_STRING,
    productionCompanies = productionCompanies.map { it.toEntity() },
    productionCountries = productionCountries.map { it.toEntity() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.toEntity() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

