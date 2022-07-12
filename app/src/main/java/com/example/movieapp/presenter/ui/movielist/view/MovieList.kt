package com.example.movieapp.presenter.ui.movielist.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.presenter.model.movie.Movie

@Composable
fun MovieList(
    movies: List<Movie>,
    modifier: Modifier = Modifier,
    onMovieClick: (Movie) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        items(movies, key = { movie -> movie.id }) { movie ->
            MovieItem(movie = movie, onMovieClick = onMovieClick)
        }
    }
}

@Composable
@Preview
fun MovieListPreview() {
    MovieList(
        movies = listOf(
            Movie(
                title = "Avengers End Game",
                overview = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
                releaseDate = "2019-08-03",
                voteAverage = 9.2,
                voteCount = 1466,
                popularity = 48.261451
            ),
            Movie(
                title = "Spiderman No Way Home",
                overview = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
                releaseDate = "2019-08-03",
                voteAverage = 9.2,
                voteCount = 1466,
                popularity = 48.261451
            ),
            Movie(
                title = "Thor: Love and Thunder",
                overview = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
                releaseDate = "2019-08-03",
                voteAverage = 9.2,
                voteCount = 1466,
                popularity = 48.261451
            )
        )
    )
}