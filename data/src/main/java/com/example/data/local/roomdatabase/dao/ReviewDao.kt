package com.example.data.local.roomdatabase.dao

import androidx.room.*
import com.example.data.local.databasemodel.review.EntityReview
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ReviewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entities: List<EntityReview>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(entities: List<EntityReview>)

    @Delete
    abstract suspend fun delete(entities: List<EntityReview>)

    @Query("SELECT * FROM review WHERE movieId = :movieId")
    abstract fun getReviewOfMovie(movieId: String): Flow<List<EntityReview>>
}