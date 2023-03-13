package com.example.movieapp.presenter.ui.detail.view.review

import com.example.movieapp.presenter.model.review.Review
import kotlinx.coroutines.flow.StateFlow

interface MovieReviewContract {
    data class ViewState(val reviews: List<Review>)

    interface ViewModel {

        fun fetchReviews(id: String)

        fun observeViewState(): StateFlow<ViewState?>
    }
}