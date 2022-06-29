package com.example.movieapp.presenter.moviedetail.review

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.movieapp.presenter.moviedetail.MovieReviewContract

@Composable
fun ReviewScreen(viewModel: MovieReviewContract.ViewModel) {
    val state by viewModel.observeViewState().observeAsState()

    state?.let {
        ReviewList(reviews = it.reviews)
    }
}