package com.example.newsjournal.presentation.screen

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.presentation.design.TopAppBar
import com.example.newsjournal.presentation.design.bottomappbar.BottomAppBar

@Composable
fun NewsScreen(navController: NavController, url: String?){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBar(
            title = "NEWS JOURNAL",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = { navController.navigate("HomePage") }
        )
        AndroidView(factory = {
            WebView(it).apply{
                webViewClient = WebViewClient()
                loadUrl(url.toString())
            }
        })

        BottomAppBar(
            navController = navController
        )
    }
}




@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen(navController = rememberNavController(), url = "https://www.nytimes.com/2025/03/29/movies/how-to-live-in-the-mall.html")
}