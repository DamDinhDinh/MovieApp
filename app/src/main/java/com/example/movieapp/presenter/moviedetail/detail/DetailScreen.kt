package com.example.movieapp.presenter.moviedetail.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.presenter.moviedetail.MovieDetailContract

@Composable
fun DetailScreen(viewModel: MovieDetailContract.ViewModel) {
    val state by viewModel.observeViewState().observeAsState()

    state?.let {
        val movie = it.movie
        Column(modifier = Modifier.background(colorResource(R.color.dark))) {
            DetailHeader(
                avatarUrl = movie.posterPathFull,
                backDropUrl = movie.backdropPathFull,
                title = movie.title,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(18.dp))
            GenreList(movie.genres)
        }
    }
}