package com.example.movieapp.presenter.ui.movielist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.R
import com.example.movieapp.presenter.model.movie.Movie
import com.example.movieapp.presenter.ui.detail.view.about.view.AboutItem

@Composable
fun MovieItem(movie: Movie, modifier: Modifier = Modifier, onMovieClick: (Movie) -> Unit = {}) {
    Row(modifier = modifier) {
        Column(verticalArrangement = Arrangement.Center) {
            Image(
                painter = rememberAsyncImagePainter(model = movie.posterPathFull),
                contentDescription = "${movie.title}'s poster",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(95.dp)
                    .height(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { onMovieClick(movie) },
                alignment = Alignment.Center,
            )
        }
        Spacer(modifier = Modifier.size(22.dp))
        Column(modifier = Modifier
            .weight(1f)
            .clickable { onMovieClick(movie) }) {
            AboutItem(
                title = stringResource(R.string.movie_title_label),
                content = movie.title
            )
            Spacer(modifier = Modifier.size(5.dp))
            AboutItem(
                title = stringResource(R.string.release_date_label),
                content = movie.releaseDate
            )
            Spacer(modifier = Modifier.size(5.dp))
            AboutItem(
                title = stringResource(R.string.average_rating_label),
                content = movie.voteAverage.toString()
            )
        }
        Spacer(modifier = Modifier.size(12.dp))
        Column(modifier = Modifier.wrapContentWidth()) {
            Image(
                painter = painterResource(R.drawable.ic_watch_list_not_add),
                contentDescription = "${movie.title}'s add to watch list",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.size(20.dp))
            Image(
                painter = painterResource(R.drawable.ic_start_not_rate),
                contentDescription = "${movie.title}'s star rate",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.primary),
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
@Preview
fun MovieItemPreview() {
    MovieItem(
        Movie(
            title = "Avengers End Game",
            overview = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
            releaseDate = "2019-08-03",
            voteAverage = 9.2,
            voteCount = 1466,
            popularity = 48.261451
        )
    )
}