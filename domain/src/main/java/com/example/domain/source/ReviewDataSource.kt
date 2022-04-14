package com.example.domain.source

import com.example.domain.model.review.ModelReview
import io.reactivex.rxjava3.core.Observable

interface ReviewDataSource {

    fun getReviewsOfMovie(movieId: Int): Observable<List<ModelReview>>
}