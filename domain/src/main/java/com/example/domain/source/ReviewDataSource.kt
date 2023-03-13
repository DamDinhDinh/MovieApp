package com.example.domain.source

import com.example.domain.model.review.ModelReview
import kotlinx.coroutines.flow.Flow

interface ReviewDataSource {

    suspend fun getReviewsOfMovie(movieId: String): Flow<List<ModelReview>>
}