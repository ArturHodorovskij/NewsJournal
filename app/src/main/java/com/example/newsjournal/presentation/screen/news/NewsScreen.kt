package com.example.newsjournal.presentation.screen.news

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newsjournal.R
import com.example.newsjournal.presentation.design.DownloadIndicator
import com.example.newsjournal.presentation.design.TopAppBar
import com.example.newsjournal.presentation.design.bottomappbar.BottomAppBar


@Composable
fun NewsScreen(
    navController: NavController,
    url: String,
    viewModel: NewsScreenViewModel = viewModel()
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadUrl(url = url)
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = "NEWS JOURNAL",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = { navController.navigateUp()}
        )

        Crossfade(
            modifier = Modifier.weight(1f),
            targetState = state, label = "Crossroad"
        ) { targetState ->
            if (targetState.isLoading) {
                DownloadIndicator()
            } else if (targetState.errorMessage != null) {
                NewsScreenError(errorMessage = targetState)
            } else NewsScreenContent(url = targetState.url)
        }

        BottomAppBar(
            navController = navController
        )
    }
}



