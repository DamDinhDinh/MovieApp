package com.example.data.local.databasemodel.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.movie.EntityMovie
import io.reactivex.rxjava3.core.Observable

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entities: List<EntityMovie>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(entities: List<EntityMovie>)

    @Delete
    abstract fun delete(entities: List<EntityMovie>)

    @Query("SELECT * FROM movie WHERE id = :id")
    abstract fun getMovieById(id: Int): Observable<EntityMovie>

    @Query("SELECT * FROM movie ORDER BY title")
    abstract fun getMovieList(): Observable<List<EntityMovie>>

    @Query("SELECT * FROM movie ORDER BY popularity DESC")
    abstract fun getPopularMovie(): Observable<List<EntityMovie>>
}