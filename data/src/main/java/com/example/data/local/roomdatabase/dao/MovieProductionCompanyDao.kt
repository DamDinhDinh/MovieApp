package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityMovieProductionCompany

@Dao
abstract class MovieProductionCompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(vararg entities: EntityMovieProductionCompany)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(vararg entities: EntityMovieProductionCompany)

    @Delete
    abstract suspend fun delete(vararg entities: EntityMovieProductionCompany)
}