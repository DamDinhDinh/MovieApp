package com.example.data.local.databasemodel.movie

import androidx.room.Entity
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT

@Entity(primaryKeys = ["movieId", "genreId"])
data class EntityMovieGenre(
    var movieId: Int = DEFAULT_INT,
    var genreId: Int = DEFAULT_INT,
)