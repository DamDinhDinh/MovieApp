package com.example.movieapp.presenter.ui.detail.view.review

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp.presenter.ui.detail.view.review.view.ReviewList

@Composable
fun ReviewScreen(viewModel: MovieReviewContract.ViewModel) {
    val state by viewModel.observeViewState().observeAsState()

    state?.let {
        ReviewList(reviews = it.reviews)
    }
}

@Composable
fun ReviewScreen() {
    val viewModel = viewModel<MovieReviewsViewModel>()
    ReviewScreen(viewModel)
}