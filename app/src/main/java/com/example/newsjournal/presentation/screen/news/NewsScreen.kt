package com.example.newsjournal.presentation.screen.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.newsjournal.R
import com.example.newsjournal.presentation.design.TopAppBar
import com.example.newsjournal.presentation.design.bottomappbar.BottomAppBar

@Composable
fun NewsScreen(navController: NavController, url: String?) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBar(
            title = "NEWS JOURNAL",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = { navController.navigate("HomePage") }
        )
        WebViewModel(url = url.toString())

        BottomAppBar(
            navController = navController
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun NewsScreenPreview() {
//    NewsScreen(navController = rememberNavController())
//}