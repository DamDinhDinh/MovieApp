package com.example.data.local.databasemodel.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityMovie
import io.reactivex.rxjava3.core.Observable

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg entities: EntityMovie)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(vararg entities: EntityMovie)

    @Delete
    abstract fun delete(vararg entities: EntityMovie)

    @Query("SELECT * FROM movie WHERE id = :id")
    abstract fun getMovieById(id: Int): Observable<EntityMovie>

    @Query("SELECT * FROM movie ORDER BY title")
    abstract fun getMovieList(id: Int): Observable<List<EntityMovie>>

    @Query("SELECT * FROM movie ORDER BY popularity DESC")
    abstract fun getPopularMovie(): Observable<List<EntityMovie>>
}