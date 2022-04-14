package com.example.domain.usecase.movie

import com.example.domain.model.review.ModelReview
import com.example.domain.source.MovieDataSource
import com.example.domain.source.ReviewDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetMovieReviewsUseCase @Inject constructor(private val reviewDataSource: ReviewDataSource) {

    operator fun invoke(request: Request): Observable<List<ModelReview>> {
        return reviewDataSource.getReviewsOfMovie(request.id)
    }

    data class Request(val id: Int)
}