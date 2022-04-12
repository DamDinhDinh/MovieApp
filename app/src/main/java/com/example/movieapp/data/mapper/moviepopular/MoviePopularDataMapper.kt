package com.example.movieapp.data.mapper.moviepopular

import com.example.movieapp.data.entities.moviepopular.JsonMoviePopularResponse
import com.example.movieapp.di.ConfigModule
import com.example.movieapp.domain.model.moviepopular.ModelMoviePopular

fun JsonMoviePopularResponse.JsonMoviePopular.toModel(): ModelMoviePopular = ModelMoviePopular(
    adult = adult,
    backdropPath = when {
        backdropPath.isNotEmpty() -> ConfigModule.getBaseImgUrl() + backdropPath
        else -> backdropPath
    },
    genreIds = genreIds,
    id,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun ModelMoviePopular.toJson(): JsonMoviePopularResponse.JsonMoviePopular =
    JsonMoviePopularResponse.JsonMoviePopular(
        adult,
        backdropPath = when {
            backdropPath.isNotEmpty() -> backdropPath.removePrefix(ConfigModule.getBaseImgUrl())
            else -> backdropPath
        },
        genreIds,
        id,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        posterPath,
        releaseDate,
        title,
        video,
        voteAverage,
        voteCount
    )