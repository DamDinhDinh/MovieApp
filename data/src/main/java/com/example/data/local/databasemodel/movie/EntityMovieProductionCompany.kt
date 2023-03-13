package com.example.data.local.databasemodel.movie

import androidx.room.Entity
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

@Entity(primaryKeys = ["movieId", "companyId"], tableName = "movie_company")
data class EntityMovieProductionCompany(
    var movieId: String = DEFAULT_STRING,
    var companyId: String = DEFAULT_STRING,
)