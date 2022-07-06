package com.example.movieapp.presenter.moviedetail.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R

@Composable
fun AboutItem(title: String, content: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.white)
        )
        Text(
            text = content,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.white),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
@Preview
fun AboutItemPreview() {
    AboutItem(
        title = "Overviews:",
        content = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences."
    )
}