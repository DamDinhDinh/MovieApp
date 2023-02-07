package com.example.domain.usecase.movie

import com.example.domain.model.review.ModelReview
import com.example.domain.source.ReviewDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieReviewsUseCase @Inject constructor(private val reviewDataSource: ReviewDataSource) {

    operator fun invoke(request: Request): Flow<List<ModelReview>> {
        return reviewDataSource.getReviewsOfMovie(request.id)
    }

    data class Request(val id: Int)
}