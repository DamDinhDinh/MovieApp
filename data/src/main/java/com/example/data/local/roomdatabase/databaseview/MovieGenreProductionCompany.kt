package com.example.data.local.roomdatabase.databaseview

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.data.local.databasemodel.movie.*

class MovieGenreProductionCompany(
    @Embedded
    val movie: EntityMovie,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "genreId",
        associateBy = Junction(EntityMovieGenre::class)
    )
    val listGenre: List<EntityGenre>,

    @Relation(
        parentColumn = "movieId",
        entityColumn = "companyId",
        associateBy = Junction(EntityMovieProductionCompany::class)
    )
    val listCompany: List<EntityProductionCompany>
)

fun MovieGenreProductionCompany.toEntity(): EntityMovie {
    return movie.apply {
        genres = listGenre
        productionCompanies = listCompany
    }
}