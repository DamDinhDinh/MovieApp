package com.example.movieapp.presenter.ui.detail.view.about.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.presenter.model.movie.Movie

@Composable
fun AboutScrollable(movie: Movie, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AboutItem(
            title = stringResource(R.string.overviews_label),
            content = movie.overview
        )
        Spacer(modifier = Modifier.size(12.dp))
        AboutItem(
            title = stringResource(R.string.release_date_label),
            content = movie.releaseDate,
        )
        Spacer(modifier = Modifier.size(12.dp))
        Row {
            AboutItem(
                title = stringResource(R.string.average_rating_label),
                content = movie.voteAverage.toString(),
                modifier = Modifier.weight(1f)
            )
            AboutItem(
                title = stringResource(R.string.rate_count_label),
                content = movie.voteCount.toString(),
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.size(12.dp))
        AboutItem(
            title = stringResource(R.string.popularity_label),
            content = movie.popularity.toInt().toString()
        )
    }
}

@Composable
@Preview
fun AboutLisPreview() {
    AboutScrollable(
        movie = Movie(
            overview = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
            releaseDate = "2019-08-03",
            voteAverage = 9.2,
            voteCount = 1466,
            popularity = 48.261451
        )
    )
}