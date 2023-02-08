package com.example.data.repo

import com.example.data.local.mapper.review.toEntity
import com.example.data.local.mapper.review.toModel
import com.example.data.local.roomdatabase.dao.ReviewDao
import com.example.data.remote.api.ReviewApi
import com.example.domain.model.review.ModelReview
import com.example.domain.source.ReviewDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ReviewRepository @Inject constructor(
    private val reviewApi: ReviewApi,
    private val reviewDao: ReviewDao
) : ReviewDataSource {

    companion object {
        private val TAG = ReviewRepository::class.simpleName
    }

    override suspend fun getReviewsOfMovie(movieId: String): Flow<List<ModelReview>> {
        fetchReviewOfMovie(movieId)
        return reviewDao.getReviewOfMovie(movieId).map { reviews -> reviews.map { it.toModel() } }
    }

    private suspend fun fetchReviewOfMovie(movieId: String) {
        reviewApi.getReviewsOfMovie(movieId).results?.map { it.toEntity().apply { this.movieId = movieId } }
            ?.let { reviewDao.insert(it) }
    }
}
