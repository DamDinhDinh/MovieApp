package com.example.movieapp.presenter.mapper.movie

import com.example.domain.model.movie.ModelGenre
import com.example.movieapp.presenter.model.movie.Genre

fun ModelGenre.toPresent(): Genre = Genre(id = id, name = name)

fun Genre.toModel(): ModelGenre = ModelGenre(id = id, name = name)

