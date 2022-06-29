package com.example.movieapp.presenter.moviedetail

import androidx.lifecycle.LiveData
import com.example.movieapp.presenter.model.review.Review

interface MovieReviewContract {
    data class ViewState(val reviews: List<Review>)

    interface ViewModel {

        fun fetchReviews(id: Int)

        fun observeViewState(): LiveData<ViewState>
    }
}