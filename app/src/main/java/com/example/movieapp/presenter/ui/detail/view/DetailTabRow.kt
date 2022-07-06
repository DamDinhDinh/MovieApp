package com.example.movieapp.presenter.ui.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R

@Composable
fun DetailTabRow(
    tabNames: List<String>,
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {}
) {
    TabRow(
        modifier = modifier,
        selectedTabIndex = selectedTabIndex,
        backgroundColor = colorResource(R.color.dark),
        indicator = { tabPositions ->
            DetailTabIndicator(
                selectedTabIndex,
                tabPositions,
                modifier = Modifier.wrapContentWidth()
            )
        },
    ) {
        tabNames.forEachIndexed { i, title ->
            Tab(
                selected = selectedTabIndex == i,
                onClick = { onClick(i) },
                modifier = Modifier.wrapContentWidth(),
                text = {
                    DetailTabContent(
                        tabName = title,
                        isSelected = selectedTabIndex == i,
                        modifier = Modifier.wrapContentWidth()
                    )
                },
            )
        }
    }
}

@Composable
fun DetailTabContent(tabName: String, isSelected: Boolean, modifier: Modifier = Modifier) {
    Text(
        text = tabName,
        color = colorResource(if (isSelected) R.color.primary else R.color.white),
        fontSize = 14.sp,
        modifier = modifier.padding(4.dp)
    )
}

@Composable
fun DetailTabIndicator(
    selectedTabIndex: Int,
    tabPositions: List<TabPosition>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .tabIndicatorOffset(tabPositions[selectedTabIndex])
            .height(4.dp)
            .background(color = colorResource(R.color.primary))
    )
}

@Composable
@Preview
fun DetailTabContentPreview() {
    DetailTabContent(tabName = "About Movie", isSelected = true)
}

@Composable
@Preview
fun DetailTabContentPreview2() {
    DetailTabContent(tabName = "Reviews", isSelected = false)
}

@Composable
@Preview(device = Devices.NEXUS_5)
fun DetailTabRowPreview() {
    DetailTabRow(listOf("About Movie", "Reviews"), 0, modifier = Modifier.wrapContentWidth())
}
