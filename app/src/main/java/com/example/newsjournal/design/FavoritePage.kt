package com.example.newsjournal.design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.newsjournal.R

@Composable
fun FavoritePage(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = "Favorite",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = {navController.navigate("HomePage")}
        )
        Separator()
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier
                .weight(1f)
        ) {
            item {
                Text(
                    text = stringResource(R.string.news),
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { }
                )
            }
        }
        Separator()
        BottomAppBar(
            firstImage = painterResource(R.drawable.home_24),
            secondImage = painterResource(R.drawable.collections_bookmark_24),
            thirdImage = painterResource(R.drawable.list_alt_24dp),
            text1Image = "Home",
            text2Image = "Favorite",
            text3Image = "Tags",
            navController = navController

        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePagePreview(){
    FavoritePage(navController = rememberNavController()
    )
}