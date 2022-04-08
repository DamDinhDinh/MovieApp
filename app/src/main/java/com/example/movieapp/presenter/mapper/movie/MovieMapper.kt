package com.example.movieapp.presenter.mapper.movie

import com.example.movieapp.domain.model.movie.ModelMovie
import com.example.movieapp.presenter.model.movie.Movie

class MovieMapper

fun Movie.toModel() = ModelMovie(
    adult = adult,
    backdropPath = backdropPath,
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


fun ModelMovie.toPresent() = Movie(
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = belongsToCollection,
    budget = budget,
    genres = genres?.map { it.toPresent() },
    homepage = homepage,
    id = id,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies?.map { it.toPresent() },
    productionCountries = productionCountries?.map { it.toPresent() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages?.map { it.toPresent() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)
