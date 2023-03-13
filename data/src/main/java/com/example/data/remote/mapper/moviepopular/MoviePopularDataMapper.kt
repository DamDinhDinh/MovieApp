package com.example.data.remote.mapper.moviepopular

import com.example.common.DefaultModelValue.Companion.DEFAULT_BOOLEAN
import com.example.common.DefaultModelValue.Companion.DEFAULT_DOUBLE
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.local.databasemodel.movie.EntityMovie
import com.example.domain.model.movie.ModelMovie
import com.example.movieapp.data.entities.moviepopular.JsonMoviePopularResponse

fun JsonMoviePopularResponse.JsonMoviePopular.toModel(): ModelMovie = ModelMovie(
    adult = adult ?: DEFAULT_BOOLEAN,
    backdropPath =
    backdropPath
        ?: DEFAULT_STRING,
    genreIds = genreIds ?: listOf(),
    id = id ?: DEFAULT_STRING,
    originalLanguage = originalLanguage ?: DEFAULT_STRING,
    originalTitle = originalTitle ?: DEFAULT_STRING,
    overview = overview ?: DEFAULT_STRING,
    popularity = popularity ?: DEFAULT_DOUBLE,
    posterPath =
    posterPath ?: DEFAULT_STRING,
    releaseDate = releaseDate ?: DEFAULT_STRING,
    title = title ?: DEFAULT_STRING,
    video = video ?: DEFAULT_BOOLEAN,
    voteAverage = voteAverage ?: DEFAULT_DOUBLE,
    voteCount = voteCount ?: DEFAULT_INT
)

fun JsonMoviePopularResponse.JsonMoviePopular.toEntity(): EntityMovie = EntityMovie(
    adult = adult ?: DEFAULT_BOOLEAN,
    backdropPath = backdropPath ?: DEFAULT_STRING,
    id = id ?: DEFAULT_STRING,
    originalLanguage = originalLanguage ?: DEFAULT_STRING,
    originalTitle = originalTitle ?: DEFAULT_STRING,
    overview = overview ?: DEFAULT_STRING,
    popularity = popularity ?: DEFAULT_DOUBLE,
    posterPath = posterPath ?: DEFAULT_STRING,
    releaseDate = releaseDate ?: DEFAULT_STRING,
    title = title ?: DEFAULT_STRING,
    video = video ?: DEFAULT_BOOLEAN,
    voteAverage = voteAverage ?: DEFAULT_DOUBLE,
    voteCount = voteCount ?: DEFAULT_INT
)