package com.example.movieapp.presenter.ui.detail.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.presenter.ui.detail.model.DetailPage

@Composable
fun DetailTabWithPage(
    detailPages: List<DetailPage>,
    selectedPage: DetailPage,
    onPageChanged: (DetailPage) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier, horizontalAlignment = Alignment.Start) {
        DetailTabRow(
            tabNames = detailPages.map { it.name },
            selectedTabIndex = detailPages.indexOf(selectedPage),
            onClick = { index -> onPageChanged(detailPages[index]) }
        )
        Spacer(modifier = Modifier.size(18.dp))
        selectedPage.content()
    }

}

