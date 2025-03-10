package com.example.newsjournal.presentation.design


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.data.retrofit.topStoriesApi.Article
import com.example.newsjournal.data.retrofit.topStoriesApi.TopStoriesRepository
import com.example.newsjournal.data.retrofit.topStoriesApi.TopStoriesViewModel


@Composable
fun HomePage(navController: NavController, tsv: TopStoriesViewModel = viewModel() ) {


    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = "NEWS JOURNAL",
            startImage = painterResource(R.drawable.person_24),
            startImageClick = {navController.navigate("LoginPage")}
        )
        Separator()
        ScrollContentWindow(articles = tsv.storiesResponse)
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



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    HomePage(navController = rememberNavController())
}