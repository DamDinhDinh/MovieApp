package com.example.movieapp.presenter.mapper.movie

import com.example.movieapp.domain.model.movie.ModelGenre
import com.example.movieapp.presenter.model.movie.Genre

class GenreMapper

fun ModelGenre.toPresent(): Genre = Genre(id = id, name = name)

fun Genre.toModel(): ModelGenre = ModelGenre(id = id, name = name)

