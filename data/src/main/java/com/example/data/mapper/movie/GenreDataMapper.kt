package com.example.data.mapper.movie

import com.example.data.jsonmodel.movie.JsonGenre
import com.example.domain.model.movie.ModelGenre

fun JsonGenre.toModel(): ModelGenre = ModelGenre(id = id, name = name)

fun ModelGenre.toJson(): JsonGenre = JsonGenre(id = id, name = name)

