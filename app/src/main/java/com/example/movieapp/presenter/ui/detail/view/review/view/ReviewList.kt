package com.example.movieapp.presenter.ui.detail.view.review.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.presenter.model.review.AuthorDetails
import com.example.movieapp.presenter.model.review.Review

@Composable
fun ReviewList(reviews: List<Review>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(
            reviews,
            key = { review -> review.id }
        ) { review ->
            ReviewItem(review = review)
        }
    }
}

@Composable
@Preview
fun ReviewListPreview() {
    ReviewList(
        reviews = listOf(
            Review(
                author = "Reviewer 1",
                authorDetails = AuthorDetails(
                    name = "Reviewer 1",
                    rating = 6,
                    username = "Author user name 1"
                ),
                content = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government.",
                createdAt = "2022-05-04"
            ),
            Review(
                author = "Reviewer 2",
                authorDetails = AuthorDetails(
                    name = "Reviewer 2",
                    rating = 7,
                    username = "Author user name 2"
                ),
                content = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government.",
                createdAt = "2022-05-04"
            ),
            Review(
                author = "Reviewer 3",
                authorDetails = AuthorDetails(
                    name = "Reviewer 3",
                    rating = 8,
                    username = "Author user name 3"
                ),
                content = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government.",
                createdAt = "2022-05-04"
            ),
            Review(
                author = "Reviewer 4",
                authorDetails = AuthorDetails(
                    name = "Reviewer 4",
                    rating = 9,
                    username = "Author user name 4"
                ),
                content = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government.",
                createdAt = "2022-05-04"
            )
        )
    )
}