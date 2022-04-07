package com.example.movieapp.data.mapper.movie

import com.example.movieapp.data.entities.movie.JsonGenre
import com.example.movieapp.domain.model.movie.ModelGenre

class GenreMapper

fun JsonGenre.toModel(): ModelGenre = ModelGenre(id = id, name = name)

fun ModelGenre.toJson(): JsonGenre = JsonGenre(id = id, name = name)

