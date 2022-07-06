package com.example.movieapp.presenter.moviedetail.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.presenter.ui.detail.MovieDetailContract
import com.example.movieapp.presenter.ui.detail.model.DetailPage

@Composable
fun DetailScreen(viewModel: MovieDetailContract.ViewModel) {
    val state by viewModel.observeViewState().observeAsState()
    val detailPages = DetailPage.values().toList()
    var selectedPage by rememberSaveable { mutableStateOf(DetailPage.ABOUT) }
    val onDetailTabClick = { newPage: DetailPage -> selectedPage = newPage }

    state?.let {
        val movie = it.movie
        Column(
            modifier = Modifier.background(colorResource(R.color.dark)),
            horizontalAlignment = Alignment.Start
        ) {
            DetailHeader(
                avatarUrl = movie.posterPathFull,
                backDropUrl = movie.backdropPathFull,
                title = movie.title,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(18.dp))
            GenreList(movie.genres)
            DetailTabWithPage(
                detailPages,
                selectedPage,
                onDetailTabClick,
                Modifier
                    .wrapContentWidth()
                    .padding(horizontal = 29.dp)
            )
        }
    }
}