package com.example.data.repo

import com.example.common.logs
import com.example.data.local.databasemodel.roomdatabase.dao.ReviewDao
import com.example.data.remote.api.ReviewApi
import com.example.data.remote.mapper.review.toModel
import com.example.domain.model.review.ModelReview
import com.example.domain.source.ReviewDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ReviewRepository @Inject constructor(
    private val reviewApi: ReviewApi,
    private val reviewDao: ReviewDao
) : ReviewDataSource {

    companion object {
        private val TAG = ReviewRepository::class.simpleName
    }

    override fun getReviewsOfMovie(movieId: Int): Single<List<ModelReview>> {
        return reviewApi.getReviewsOfMovie(movieId)
            .logs("$TAG getReviews")
            .map { response ->
                if (!response.results.isNullOrEmpty()) response.results.map { it.toModel() } else listOf()
            }
    }
}
