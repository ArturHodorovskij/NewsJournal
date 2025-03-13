package com.example.newsjournal.presentation.home


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.presentation.design.BottomAppBar
import com.example.newsjournal.presentation.design.Separator
import com.example.newsjournal.presentation.design.TopAppBar
import com.example.newsjournal.presentation.design.TopStoriesViewModel


@Composable
fun HomeScreen(navController: NavController, viewModel: TopStoriesViewModel = viewModel()) {

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

        Separator()

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
//                item.multimedia?.forEach {
//
//                    Image(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(200.dp),
//                        painter = it,
//                        contentDescription = ""
//                    )
//                }
                        Text(
                            fontSize = 16.sp,
                            text = item.title,
                            modifier = Modifier
                                .padding(8.dp)
                        )

                        Text(
                            text = item.abstract,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(8.dp)
                        )
                        Separator()
                    }
                }
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    HomeScreen(navController = rememberNavController())
}