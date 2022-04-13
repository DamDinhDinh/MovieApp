package com.example.data.local.databasemodel.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityMovieGenre

@Dao
abstract class MovieGenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entities: EntityMovieGenre)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(vararg entities: EntityMovieGenre)

    @Delete
    abstract fun delete(vararg entities: EntityMovieGenre)
}