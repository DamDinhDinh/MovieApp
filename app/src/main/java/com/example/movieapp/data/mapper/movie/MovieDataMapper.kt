package com.example.movieapp.data.mapper.movie

import com.example.movieapp.data.entities.movie.JsonMovie
import com.example.movieapp.di.ConfigModule
import com.example.movieapp.domain.model.movie.ModelMovie

class MovieMapper

fun JsonMovie.toModel() = ModelMovie(
    adult = adult,
    backdropPath = if (backdropPath != null && backdropPath.isNotEmpty()) ConfigModule.getBaseImgUrl() + backdropPath else backdropPath,
    belongsToCollection = belongsToCollection,
    budget = budget,
    genres = genres?.map { it.toModel() },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies?.map { it.toModel() },
    productionCountries = productionCountries?.map { it.toModel() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages?.map { it.toModel() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun ModelMovie.toJson() = JsonMovie(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = belongsToCollection,
    budget = budget,
    genres = genres?.map { it.toJson() },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies?.map { it.toJson() },
    productionCountries = productionCountries?.map { it.toJson() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages?.map { it.toJson() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

