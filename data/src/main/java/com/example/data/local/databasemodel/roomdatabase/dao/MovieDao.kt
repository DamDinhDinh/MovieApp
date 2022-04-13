package com.example.data.local.databasemodel.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityMovie

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entities: EntityMovie)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(vararg entities: EntityMovie)

    @Delete
    abstract fun delete(vararg entities: EntityMovie)
}