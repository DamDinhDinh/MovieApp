package com.example.data.remote.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.movie.JsonGenre
import com.example.domain.model.movie.ModelGenre

fun JsonGenre.toModel(): ModelGenre =
    ModelGenre(id = id ?: DEFAULT_STRING, name = name ?: DEFAULT_STRING)

fun ModelGenre.toJson(): JsonGenre = JsonGenre(id = id, name = name)

