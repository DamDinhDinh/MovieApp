package com.example.movieapp.presenter.moviedetail.review

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.R
import com.example.movieapp.presenter.model.review.AuthorDetails
import com.example.movieapp.presenter.model.review.Review

@Composable
fun ReviewItem(review: Review, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        UserAvatarAndRating(review.authorDetails.avatarPathFull, review.authorDetails.rating)
        Column {
            AuthorNameAndDetail(
                authorName = review.authorDetails.name,
                createdDate = review.createdAtDDMMYYYY,
                modifier = Modifier.padding(start = 12.dp)
            )
            Spacer(modifier = Modifier.size(12.dp))
            ReviewContent(content = review.content, Modifier.padding(start = 12.dp))
        }
    }
}

@Composable
private fun UserAvatarAndRating(url: String, rating: Int, modifier: Modifier = Modifier) {
    Log.e("UserAvatarAndRating: ", "url = $url")
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = "",
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = rating.toString(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.primary),
        )
    }
}

@Composable
private fun AuthorNameAndDetail(
    authorName: String,
    createdDate: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            text = authorName,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(end = 12.dp)
                .weight(1f),
        )
        Text(
            text = createdDate, fontSize = 12.sp,
            color = colorResource(R.color.white),
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Composable
private fun ReviewContent(content: String, modifier: Modifier = Modifier) {
    Text(
        text = content,
        fontSize = 12.sp,
        color = colorResource(R.color.white),
        modifier = modifier
    )
}

@Composable
@Preview
fun ReviewItemPreview() {
    ReviewItem(
        Review(
            author = "Reviewer",
            authorDetails = AuthorDetails(
                name = "Reviewer",
                rating = 6,
                username = "Author user name"
            ),
            content = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government.",
            createdAt = "2022-05-04"
        )
    )
}