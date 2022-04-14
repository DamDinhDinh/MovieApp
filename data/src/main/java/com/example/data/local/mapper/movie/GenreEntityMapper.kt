package com.example.data.local.mapper.movie

import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING
import com.example.data.local.databasemodel.movie.EntityGenre
import com.example.data.remote.jsonmodel.movie.JsonGenre
import com.example.domain.model.movie.ModelGenre

//from this
fun EntityGenre.toJson() = JsonGenre(id = id, name = name)

fun EntityGenre.toModel() = ModelGenre(id = id, name = name)

//other map to this
fun JsonGenre.toEntity() = EntityGenre(id = id ?: DEFAULT_INT, name = name ?: DEFAULT_STRING)

fun ModelGenre.toEntity() = EntityGenre(id, name)