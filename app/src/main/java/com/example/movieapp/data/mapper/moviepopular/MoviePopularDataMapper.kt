package com.example.movieapp.data.mapper.moviepopular

import com.example.movieapp.data.entities.moviepopular.JsonMoviePopularResponse
import com.example.movieapp.domain.model.moviepopular.ModelMoviePopular

class MoviePopularDataMapper

fun JsonMoviePopularResponse.JsonMoviePopular.toModel(): ModelMoviePopular = ModelMoviePopular(
    adult = adult ?: false,
    backdropPath = "https://image.tmdb.org/t/p/w500$backdropPath" ?: "",
    genreIds = genreIds ?: mutableListOf(),
    id,
    originalLanguage = originalLanguage ?: "",
    originalTitle = originalTitle ?: "",
    overview = overview ?: "",
    popularity = popularity ?: 0.0,
    posterPath = posterPath ?: "",
    releaseDate = releaseDate ?: "",
    title = title ?: "",
    video = video ?: false,
    voteAverage = voteAverage ?: 0.0,
    voteCount = voteCount ?: 0
)

fun ModelMoviePopular.toJson(): JsonMoviePopularResponse.JsonMoviePopular =
    JsonMoviePopularResponse.JsonMoviePopular(
        adult,
        backdropPath,
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