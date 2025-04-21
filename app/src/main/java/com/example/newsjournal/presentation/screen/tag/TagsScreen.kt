package com.example.newsjournal.presentation.screen.tag
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.data.nyt.models.tagsTitle
import com.example.newsjournal.presentation.design.Separator
import com.example.newsjournal.presentation.design.TopAppBar
import com.example.newsjournal.presentation.design.bottomappbar.BottomAppBar
import androidx.compose.foundation.lazy.items

@Composable
fun TagsScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        TopAppBar(
            title = "Tags",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = { navController.popBackStack("HomePage",false) }
        )

        LazyColumn(
            state = rememberLazyListState(),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp)
        ) {
            items(tagsTitle) { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("TagContentScreen/$item")
                        }
                ) {
                    Text(
                        text = item,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                    )
                }
                Separator()
            }
        }

        BottomAppBar(
            navController = navController,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TagsPagePreview() {
    TagsScreen(
        navController = rememberNavController()
    )
}