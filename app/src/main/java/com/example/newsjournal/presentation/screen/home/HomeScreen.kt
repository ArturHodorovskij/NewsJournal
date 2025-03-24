package com.example.newsjournal.presentation.screen.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.presentation.design.TopAppBar
import com.example.newsjournal.presentation.design.bottomappbar.BottomAppBar
import com.example.newsjournal.presentation.design.DownloadIndicator

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = viewModel()) {

    val state by viewModel.state.observeAsState()
    val tag = "home"

    LaunchedEffect(Unit) {
        viewModel.loadData(section = tag)
    }
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
                is HomeScreenState.Content -> HomeScreenContent(someState = targetState)
                is HomeScreenState.Error -> ErrorDialog(errorMessage = targetState)
                else -> Unit
            }
        }

        BottomAppBar(
            navController = navController
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    HomeScreen(navController = rememberNavController())
}

