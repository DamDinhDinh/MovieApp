package com.example.movieapp.presenter.ui.detail.view.about

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieapp.presenter.ui.detail.view.about.view.AboutScrollable
import com.example.movieapp.presenter.ui.detail.MovieDetailContract
import com.example.movieapp.presenter.ui.detail.MovieDetailViewModel

@Composable
fun AboutScreen(viewModel: MovieDetailContract.ViewModel) {
    val state by viewModel.observeViewState().observeAsState()

    state?.let {
        AboutScrollable(movie = it.movie)
    }
}

@Composable
fun AboutScreen() {
    val viewModel = viewModel<MovieDetailViewModel>()
    AboutScreen(viewModel)
}