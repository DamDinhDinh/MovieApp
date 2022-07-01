package com.example.movieapp.presenter.moviedetail.about

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.movieapp.presenter.moviedetail.MovieDetailContract

@Composable
fun AboutScreen(viewModel: MovieDetailContract.ViewModel) {
    val state by viewModel.observeViewState().observeAsState()

    state?.let {
        AboutScrollable(movie = it.movie)
    }
}