package com.example.newsjournal.presentation.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.domain.Multimedia
import com.example.newsjournal.domain.TopStoriesResponse


@Composable
fun ScrollContentWindow(topStoriesResponse: TopStoriesResponse) {
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier
            .height(600.dp) // weight(1f) почему тут не работает, а в FavoritePage работает?
    ) {
        items(topStoriesResponse.results) { item ->
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

                Text(text = item.abstract,
                        fontSize = 12.sp,
                    modifier = Modifier
                        .padding(8.dp))
                Separator()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PrimaryContentLine() {
}

