package com.example.newsjournal.presentation.screen.news

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
    newsScreenViewModel: NewsScreenViewModel = viewModel()
) {

    val state by newsScreenViewModel.state.observeAsState()

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
            when (targetState) {
                is NewsScreenState.Initial -> Unit
                is NewsScreenState.Loading -> DownloadIndicator()
//                is NewsScreenState.Content -> NewsScreenContentWebView(article = targetState.items)
                is NewsScreenState.Content -> NewsScreenContent(article = targetState.items)
                is NewsScreenState.Error -> NewsScreenError(errorMessage = targetState)
                else -> Unit
            }
        }
        BottomAppBar(
            navController = navController
        )
    }
}



