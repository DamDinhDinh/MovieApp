package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityGenre
import kotlinx.coroutines.flow.Flow

@Dao
abstract class GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entities: EntityGenre)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(vararg entities: EntityGenre)

    @Delete
    abstract fun delete(vararg entities: EntityGenre)

    @Query("SELECT * FROM genre WHERE genreId = :id")
    abstract fun getGenreById(id: Int): Flow<EntityGenre>

    @Query("SELECT * FROM genre")
    abstract fun getListGenre(): Flow<EntityGenre>
}