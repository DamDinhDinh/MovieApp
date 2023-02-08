package com.example.data.local.databasemodel.movie

import androidx.room.Entity
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

@Entity(primaryKeys = ["movieId", "genreId"], tableName = "movie_genre")
data class EntityMovieGenre(
    var movieId: String = DEFAULT_STRING,
    var genreId: String = DEFAULT_STRING,
)