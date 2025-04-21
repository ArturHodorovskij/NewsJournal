package com.example.newsjournal.presentation.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.newsjournal.data.backendless.models.BackendlessArticle
import com.example.newsjournal.domain.models.backandless.NewsDetails
import com.example.newsjournal.presentation.design.CustomImage
import com.example.newsjournal.presentation.design.Separator
import com.example.newsjournal.presentation.screen.news.NewsScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    navController: NavController,
    articles: List<NewsDetails>,
    newsScreenViewModel: NewsScreenViewModel = viewModel(),
    refreshData: () -> Unit
) {
    val state = rememberPullToRefreshState()
    var isRefreshing: Boolean by remember { mutableStateOf(false) }

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true
            refreshData()
            isRefreshing = false
        },
        state = state
    ) {
        LazyColumn(state = rememberLazyListState()) {
            items(articles) { item ->
                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
//                            newsScreenViewModel.loadNews(items = item)
                            navController.navigate("NewsScreen")
                        }
                ) {
                    CustomImage(
                        imageUrl = item.imageUrl,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )

                    Text(
                        fontSize = 16.sp,
                        text = item.title,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier
                            .padding(8.dp)
                    )

                    Text(
                        text = item.description,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Separator()
                }
            }
        }
    }
}