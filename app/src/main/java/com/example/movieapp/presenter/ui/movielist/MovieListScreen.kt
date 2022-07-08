package com.example.movieapp.presenter.ui.movielist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R
import com.example.movieapp.presenter.ui.common.genre.GenreList
import com.example.movieapp.presenter.ui.common.search.SearchBar
import com.example.movieapp.presenter.ui.movielist.view.MovieList

@Composable
fun MovieListScreen(viewModel: MovieListContract.ViewModel) {
    val state by viewModel.observeViewState().observeAsState()
    var searchQuery by rememberSaveable { mutableStateOf("") }

    state?.let {
        val movies = it.movieList
        Column(
            modifier = Modifier.background(colorResource(R.color.dark)),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.size(29.dp))
            Text(
                text = stringResource(R.string.app_name_label),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 29.dp),
                color = colorResource(R.color.white)
            )
            Spacer(modifier = Modifier.size(22.dp))
            Text(
                text = stringResource(R.string.find_your_movies_label),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 29.dp),
                color = colorResource(R.color.white)
            )
            Spacer(modifier = Modifier.size(18.dp))
            SearchBar(
                placeHolder = stringResource(R.string.search_here_label),
                query = searchQuery,
                onQueryChange = { newQuery -> searchQuery = newQuery },
                modifier = Modifier
                    .padding(horizontal = 29.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(22.dp))
            Text(
                text = stringResource(R.string.categories_label),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 29.dp),
                color = colorResource(R.color.white)
            )
            Spacer(modifier = Modifier.size(18.dp))
            GenreList(genres = movies.flatMap { movie -> movie.genres }.distinct())
            Spacer(modifier = Modifier.size(29.dp))
            MovieList(movies = movies,
                modifier = Modifier
                    .padding(horizontal = 29.dp)
                    .fillMaxWidth(),
                onMovieClick = { movie -> viewModel.onMovieClick(movie) })
        }
    }
}