package com.example.movieapp.presenter.moviedetail.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R

@Composable
fun GenreItem(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        fontSize = 12.sp,
        color = colorResource(R.color.white),
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(
                color = colorResource(R.color.dark2)
            )
            .padding(start = 12.dp, top = 2.dp, end = 12.dp, bottom = 2.dp)
    )
}

@Composable
@Preview
fun GenreItemPreview() {
    GenreItem(name = "Action")
}