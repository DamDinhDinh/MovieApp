package com.example.data.repo

import com.example.common.dataSchedulers
import com.example.common.logs
import com.example.data.local.mapper.review.toEntity
import com.example.data.local.mapper.review.toModel
import com.example.data.local.roomdatabase.dao.ReviewDao
import com.example.data.remote.api.ReviewApi
import com.example.domain.model.review.ModelReview
import com.example.domain.source.ReviewDataSource
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import javax.inject.Inject

class ReviewRepository @Inject constructor(
    private val reviewApi: ReviewApi,
    private val reviewDao: ReviewDao
) : ReviewDataSource {

    companion object {
        private val TAG = ReviewRepository::class.simpleName
    }

    override fun getReviewsOfMovie(movieId: Int): Observable<List<ModelReview>> {
        fetchReviewOfMovie(movieId)

        return reviewDao.getReviewOfMovie(movieId)
            .logs("$TAG local getReviewsOfMovie id =$movieId ")
            .map { list -> list.map { it.toModel() } }
    }

    fun fetchReviewOfMovie(movieId: Int) {
        reviewApi.getReviewsOfMovie(movieId)
            .dataSchedulers()
            .logs("$TAG remote fetchReviewOfMovie id = $movieId")
            .map { response ->
                response.results?.map {
                    it.toEntity().apply { this.movieId = movieId }
                } ?: listOf()
            }
            .subscribe({ list -> reviewDao.insert(list) },
                { error -> Timber.e("$TAG remote fetchReviewOfMovie id = $movieId ${error.message}") })
    }
}
