package com.example.movieapp.presenter.ui.detail.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.example.movieapp.R
import com.example.movieapp.presenter.ui.detail.view.about.AboutScreen
import com.example.movieapp.presenter.ui.detail.view.review.ReviewScreen

enum class DetailPage(@StringRes val titleRes: Int, val content: @Composable () -> Unit) {

    ABOUT(R.string.about_movie_label, content = {
        AboutScreen()
    }),
    REVIEWS(R.string.reviews_label, content = {
        ReviewScreen()
    })
}