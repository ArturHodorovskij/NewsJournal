package com.example.newsjournal.design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.R

@Composable
fun TagsPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        TopAppBar(
            title = "Tags",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = {
            }
        )
        Separator()
        LazyColumn(
            state = rememberLazyListState(),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp)
        ) {
            items(TagsName().tagsTitle) { item ->
                Box(
                    modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                ) {
                    Text(
                        text = item,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                    )
                }
                Separator()
            }
        }
        Separator()
        BottomAppBar(
            firstImage = painterResource(R.drawable.home_24),
            secondImage = painterResource(R.drawable.collections_bookmark_24),
            thirdImage = painterResource(R.drawable.list_alt_24dp),
            startImageClick = { },
            text1Image = "Home",
            text2Image = "Favorite",
            text3Image = "Tags"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TagsPagePreview() {
    TagsPage()
}