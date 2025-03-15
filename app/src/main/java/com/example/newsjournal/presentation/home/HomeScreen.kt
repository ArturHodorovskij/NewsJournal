package com.example.newsjournal.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.newsjournal.R
import com.example.newsjournal.presentation.design.Separator
import com.example.newsjournal.presentation.design.TopAppBar
import com.example.newsjournal.presentation.design.bottomappbar.BottomAppBar

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = viewModel()) {

    val state by viewModel.topStoriesResponse.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.load()
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

        state?.let {
            LazyColumn(
                state = rememberLazyListState(),
                modifier = Modifier.weight(1f)
            ) {
                items(it.results) { item ->
                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { }

                    ) {
                        val firstImage = item.multimedia?.firstOrNull()?.url
                        if (firstImage != null) {
                            val painter = rememberAsyncImagePainter(firstImage)
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                painter = painter,
                                contentDescription = ""
                            )
                        }
                        
                        Text(
                            fontSize = 16.sp,
                            text = item.title,
                            fontWeight = FontWeight.Black,
                            modifier = Modifier
                                .padding(8.dp)
                        )

                        Text(
                            text = item.abstract,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                        Separator()
                    }
                }
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