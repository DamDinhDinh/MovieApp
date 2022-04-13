package com.example.domain.source

import com.example.domain.model.review.ModelReview
import io.reactivex.rxjava3.core.Single

interface ReviewDataSource {

    fun getReviewsOfMovie(movieId: Int): Single<List<ModelReview>>
}