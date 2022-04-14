package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.review.EntityReview
import io.reactivex.rxjava3.core.Observable

@Dao
abstract class ReviewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(entities: List<EntityReview>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(entities: List<EntityReview>)

    @Delete
    abstract fun delete(entities: List<EntityReview>)

    @Query("SELECT * FROM review WHERE movieId = :movieId")
    abstract fun getReviewOfMovie(movieId: Int): Observable<List<EntityReview>>
}