package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityMovieGenre

@Dao
abstract class MovieGenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(vararg entities: EntityMovieGenre)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(vararg entities: EntityMovieGenre)

    @Delete
    abstract suspend fun delete(vararg entities: EntityMovieGenre)
}