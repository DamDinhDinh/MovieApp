package com.example.movieapp.presenter.ui.common.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R

@Composable
fun SearchBar(
    placeHolder: String,
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            singleLine = true,
            placeholder = {
                Text(
                    text = placeHolder,
                    fontSize = 14.sp,
                    color = colorResource(R.color.white),
                )
            },
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(color = colorResource(R.color.dark2)),
            textStyle = TextStyle(color = colorResource(R.color.white), fontSize = 14.sp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.size(23.dp))
        Image(
            painter = painterResource(R.drawable.ic_search_btn),
            contentDescription = "Search Button",
            modifier = Modifier
                .size(42.dp)
        )
    }
}

@Composable
@Preview
fun SearchBarPreview() {
    SearchBar(placeHolder = "Search here ...", query = "", onQueryChange = {})
}