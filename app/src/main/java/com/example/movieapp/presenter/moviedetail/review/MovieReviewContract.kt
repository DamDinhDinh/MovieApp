package com.example.movieapp.presenter.moviedetail.review

import androidx.lifecycle.LiveData
import com.example.movieapp.presenter.model.review.Review

interface MovieReviewContract {
    data class ViewState(val reviews: List<Review>)

    interface View {
        fun updateViewState(viewState: ViewState)
    }

    interface ViewModel {

        fun fetchReviews(id: Int)

        fun observeViewState(): LiveData<ViewState>
    }
}