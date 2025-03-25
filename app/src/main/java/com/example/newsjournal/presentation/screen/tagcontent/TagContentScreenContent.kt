package com.example.newsjournal.presentation.screen.tagcontent

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.newsjournal.presentation.design.Separator

@Composable
fun TagContentScreenContent(tagContentScreenState: TagContentScreenState.Content) {

    tagContentScreenState.items?.let {
        LazyColumn(
            state = rememberLazyListState(),
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
}
