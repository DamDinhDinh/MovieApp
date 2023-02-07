package com.example.domain.source

import com.example.domain.model.review.ModelReview
import kotlinx.coroutines.flow.Flow

interface ReviewDataSource {

    fun getReviewsOfMovie(movieId: Int): Flow<List<ModelReview>>
}