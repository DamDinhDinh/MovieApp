package com.example.data.local.databasemodel.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityGenre

@Dao
abstract class GenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entities: EntityGenre)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(vararg entities: EntityGenre)

    @Delete
    abstract fun delete(vararg entities: EntityGenre)
}