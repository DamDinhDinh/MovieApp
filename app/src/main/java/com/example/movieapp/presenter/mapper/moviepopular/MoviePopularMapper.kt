package com.example.movieapp.presenter.mapper.moviepopular

import com.example.domain.model.moviepopular.ModelMoviePopular
import com.example.movieapp.presenter.model.moviepopular.MoviePopular

fun ModelMoviePopular.toPresent(): MoviePopular = MoviePopular(
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

fun MoviePopular.toModel(): ModelMoviePopular = ModelMoviePopular(
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