package com.example.movieapp.presenter.moviedetail.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun DetailHeader(
    avatarUrl: String,
    backDropUrl: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .wrapContentHeight()
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = backDropUrl),
            contentDescription = "Backdrop image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .align(Alignment.TopStart)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
        )
        Image(
            painter = rememberAsyncImagePainter(model = avatarUrl),
            contentDescription = "Avatar image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(start = 24.dp, top = 150.dp)
                .width(90.dp)
                .height(120.dp)
                .align(Alignment.TopStart)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 23.sp,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(start = 126.dp, top = 214.dp, end = 12.dp)
                .align(Alignment.TopStart)
        )
    }
}

@Composable
@Preview
fun DetailHeaderPreview() {
    DetailHeader(
        "https://storage.googleapis.com/prod-dam-products/ec849f143fda493db8905040063c7c89.jpg",
        "https://storage.googleapis.com/prod-dam-products/af7f1f14d4e5410aa75186365982afae.jpg",
        "Spiderman No Way Home"
    )
}