package com.example.newsjournal.presentation.screen.tagcontent

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
import com.example.newsjournal.presentation.design.DownloadIndicator
import com.example.newsjournal.presentation.design.TopAppBar
import com.example.newsjournal.presentation.design.bottomappbar.BottomAppBar
import com.example.newsjournal.presentation.screen.tag.TagsScreen

@Composable
fun TagContentScreen(navController: NavController, tag:String?, viewModel: TagContentViewModel = viewModel()) {

    val state by viewModel.state.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.loadData(section = tag.toString())
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        TopAppBar(
            title = "$tag",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = { navController.navigate("TagsPage") }
        )

        Crossfade(
            modifier = Modifier.weight(1f),
            targetState = state, label = "Crossroad"
        ) { targetState ->
            when (targetState) {
                is TagContentScreenState.Initial -> Unit
                is TagContentScreenState.Loading -> DownloadIndicator()
                is TagContentScreenState.Content -> TagContentScreenContent(tagContentScreenState = targetState)
                is TagContentScreenState.Error -> TagContentScreenError(errorMessage = targetState)
                else -> Unit
            }
        }

        BottomAppBar(
            navController = navController,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TagContentScreen() {
    TagsScreen(
        navController = rememberNavController()
    )
}