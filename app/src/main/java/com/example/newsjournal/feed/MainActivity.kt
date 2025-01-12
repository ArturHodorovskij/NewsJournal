package com.example.newsjournal.feed

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.R
import com.example.newsjournal.design.BottomAppBar
import com.example.newsjournal.design.TopAppBar
import com.example.newsjournal.ui.theme.NewsJournalTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsJournalTheme {
                Surface(
//                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                    ) {
                    HomePage(this)
                }
            }
        }
        applicationContext
    }
}

@Composable

fun HomePage(context: Context) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = "NEWS JOURNAL",
            startImage = painterResource(R.drawable.person_24),
            startImageClick = {
                Toast.makeText(context, "text", Toast.LENGTH_LONG).show()
            }
        )

        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            item {
                Text(
                    text = stringResource(R.string.news),
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { }
                )
            }
        }
                BottomAppBar(
                    firstImage = painterResource(R.drawable.home_24),
                    secondImage = painterResource(R.drawable.star_24),
                    thirdImage = painterResource(R.drawable.collections_bookmark_24),
                    startImageClick = { Toast.makeText(context, "text", Toast.LENGTH_LONG).show() },
                    text1Image = "Home",
                    text2Image = "Favorite",
                    text3Image = "Tags"
                )
            }
        }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    NewsJournalTheme {
    }
}