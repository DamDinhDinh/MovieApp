package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityMovieProductionCompany

@Dao
abstract class MovieProductionCompanyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entities: EntityMovieProductionCompany)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(vararg entities: EntityMovieProductionCompany)

    @Delete
    abstract fun delete(vararg entities: EntityMovieProductionCompany)
}