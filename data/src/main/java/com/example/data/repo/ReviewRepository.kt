package com.example.data.repo

import com.example.data.remote.api.ReviewApi
import com.example.data.remote.mapper.review.toModel
import com.example.domain.model.review.ModelReview
import com.example.domain.source.ReviewDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReviewRepository @Inject constructor(
    private val reviewApi: ReviewApi
) : ReviewDataSource {

    companion object {
        private val TAG = ReviewRepository::class.simpleName
    }

    override fun getReviewsOfMovie(movieId: Int): Flow<List<ModelReview>> = flow {
        emit(reviewApi.getReviewsOfMovie(movieId).results?.map { it.toModel() } ?: listOf())
    }
}
