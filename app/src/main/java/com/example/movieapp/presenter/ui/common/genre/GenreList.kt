package com.example.movieapp.presenter.ui.common.genre

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.presenter.model.movie.Genre

@Composable
fun GenreList(genres: List<Genre>, modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 29.dp)
    ) {
        items(
            genres,
            key = { genre -> genre.id }
        ) { genre ->
            GenreItem(name = genre.name)
        }
    }
}