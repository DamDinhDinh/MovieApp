package com.example.data.local.databasemodel.movie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.common.DefaultModelValue.Companion.DEFAULT_BOOLEAN
import com.example.common.DefaultModelValue.Companion.DEFAULT_DOUBLE
import com.example.common.DefaultModelValue.Companion.DEFAULT_INT
import com.example.common.DefaultModelValue.Companion.DEFAULT_STRING

@Entity(tableName = "movie")
data class EntityMovie(
    var adult: Boolean = DEFAULT_BOOLEAN,
    var backdropPath: String = DEFAULT_STRING,
    @Ignore
    var belongsToCollection: Any = Any(), // don't know what is this
    var budget: Int = DEFAULT_INT,
    @Ignore
    var genres: List<EntityGenre> = listOf(), // save as EntityMovieGenre
    var homepage: String = DEFAULT_STRING,
    @PrimaryKey
    @ColumnInfo(name = "movieId")
    var id: Int = DEFAULT_INT,
    var imdbId: String = DEFAULT_STRING,
    var originalLanguage: String = DEFAULT_STRING,
    var originalTitle: String = DEFAULT_STRING,
    var overview: String = DEFAULT_STRING,
    var popularity: Double = DEFAULT_DOUBLE,
    var posterPath: String = DEFAULT_STRING,
    @Ignore
    var productionCompanies: List<EntityProductionCompany> = listOf(), // save as EntityMovieProductionCompany
    var productionCountries: List<EntityProductionCountry> = listOf(), // save as json list
    var releaseDate: String = DEFAULT_STRING,
    var revenue: Int = DEFAULT_INT,
    var runtime: Int = DEFAULT_INT,
    var spokenLanguages: List<EntitySpokenLanguage> = listOf(), //save as json list
    var status: String = DEFAULT_STRING,
    var tagline: String = DEFAULT_STRING,
    var title: String = DEFAULT_STRING,
    var video: Boolean = DEFAULT_BOOLEAN,
    var voteAverage: Double = DEFAULT_DOUBLE,
    var voteCount: Int = DEFAULT_INT
)