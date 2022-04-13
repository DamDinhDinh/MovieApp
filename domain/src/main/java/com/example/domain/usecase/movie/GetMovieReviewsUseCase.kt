package com.example.domain.usecase.movie

import com.example.domain.model.review.ModelReview
import com.example.domain.source.MovieDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetMovieReviewsUseCase @Inject constructor(private val movieDataSource: MovieDataSource) {

    operator fun invoke(request: Request): Single<List<ModelReview>> {
        return movieDataSource.getReviews(request.id)
    }

    data class Request(val id: Int)
}