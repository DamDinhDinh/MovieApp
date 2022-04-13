package com.example.data.remote.mapper.moviepopular

import com.example.common.DefaultModelValue.Companion.DEFAULT_BOOLEAN
import com.example.common.DefaultModelValue.Companion.DEFAULT_DOUBLE
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.di.ConfigModule
import com.example.domain.model.moviepopular.ModelMoviePopular
import com.example.movieapp.data.entities.moviepopular.JsonMoviePopularResponse

fun JsonMoviePopularResponse.JsonMoviePopular.toModel(): ModelMoviePopular = ModelMoviePopular(
    adult = adult ?: DEFAULT_BOOLEAN,
    backdropPath = when {
        !backdropPath.isNullOrEmpty() -> ConfigModule.getBaseImgUrl() + backdropPath
        else -> DEFAULT_STRING
    },
    genreIds = genreIds ?: listOf(),
    id = id ?: DEFAULT_INT,
    originalLanguage = originalLanguage ?: DEFAULT_STRING,
    originalTitle = originalTitle ?: DEFAULT_STRING,
    overview = overview ?: DEFAULT_STRING,
    popularity = popularity ?: DEFAULT_DOUBLE,
    posterPath = when {
        !posterPath.isNullOrEmpty() -> ConfigModule.getBaseImgUrl() + posterPath
        else -> DEFAULT_STRING
    },
    releaseDate = releaseDate ?: DEFAULT_STRING,
    title = title ?: DEFAULT_STRING,
    video = video ?: DEFAULT_BOOLEAN,
    voteAverage = voteAverage ?: DEFAULT_DOUBLE,
    voteCount = voteCount ?: DEFAULT_INT
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