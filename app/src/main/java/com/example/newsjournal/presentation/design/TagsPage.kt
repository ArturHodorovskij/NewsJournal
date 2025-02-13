package com.example.newsjournal.presentation.design

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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.data.retrofit.topStoriesApi.getTopStories

@Composable
fun TagsPage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        TopAppBar(
            title = "Tags",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = { navController.navigate("HomePage") }
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
            items(getTags()) { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val getarts = getArts(item.tag)
                            val s = getarts
                        }

                ) {
                    Text(
                        text = item.tag,
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
            navController = navController,
            text1Image = "Home",
            text2Image = "Favorite",
            text3Image = "Tags"

        )
    }
}

fun getTags(): List<NewsTag> = listOf(NewsTag("arts"), NewsTag("world"), NewsTag("food"))

fun getArts(tag: String) {
    getTopStories(tag)
}

@Preview(showBackground = true)
@Composable
fun TagsPagePreview() {
    TagsPage(
        navController = rememberNavController()
    )
}