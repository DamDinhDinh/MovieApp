package com.example.data.local.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.remote.jsonmodel.movie.JsonGenre
import com.example.data.local.databasemodel.movie.EntityGenre

fun JsonGenre.toEntity(): EntityGenre =
    EntityGenre(id = id ?: DEFAULT_INT, name = name ?: DEFAULT_STRING)

fun EntityGenre.toJson(): JsonGenre = JsonGenre(id = id, name = name)

