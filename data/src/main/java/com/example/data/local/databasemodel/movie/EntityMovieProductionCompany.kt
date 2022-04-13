package com.example.data.local.databasemodel.movie

import androidx.room.Entity
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT

@Entity(primaryKeys = ["movieId", "companyId"], tableName = "movie_company")
data class EntityMovieProductionCompany(
    var movieId: Int = DEFAULT_INT,
    var companyId: Int = DEFAULT_INT,
)