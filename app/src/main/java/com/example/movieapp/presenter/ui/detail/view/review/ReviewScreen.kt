package com.example.movieapp.presenter.ui.detail.view.review

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp.presenter.ui.detail.view.review.view.ReviewList

@Composable
fun ReviewScreen(viewModel: MovieReviewContract.ViewModel) {
    val state by viewModel.observeViewState().collectAsState()

    state?.let {
        ReviewList(reviews = it.reviews)
    }
}

@Composable
fun ReviewScreen() {
    val viewModel = viewModel<MovieReviewsViewModel>()
    ReviewScreen(viewModel)
}