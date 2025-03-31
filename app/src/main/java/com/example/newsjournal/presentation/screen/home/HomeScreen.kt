package com.example.newsjournal.presentation.screen.home

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
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = viewModel()) {

    val state by viewModel.state.observeAsState()

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBar(
            title = "NEWS JOURNAL",
            startImage = painterResource(R.drawable.person_24),
            startImageClick = { navController.navigate("LoginPage") }
        )

        Crossfade(
            modifier = Modifier.weight(1f),
            targetState = state, label = "Crossroad"
        ) { targetState ->
            when (targetState) {
                is HomeScreenState.Initial -> Unit
                is HomeScreenState.Loading -> DownloadIndicator()
                is HomeScreenState.Content -> HomeScreenContent(
                    refreshData = viewModel::reloadData,
                    topStories = targetState.items,
                    navController = navController
                )

                is HomeScreenState.Error -> HomeScreenError(
                    errorMessage = targetState,
                    refreshData = viewModel::reloadData,
                )

                else -> Unit
            }
        }

        BottomAppBar(
            navController = navController
        )
    }
}