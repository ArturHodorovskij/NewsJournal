package com.example.newsjournal.presentation.screen.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.domain.models.NYT.Article
import com.example.newsjournal.domain.models.backandless.NewsDetails
import com.example.newsjournal.presentation.design.CustomImage

@Composable
fun NewsScreenContent(article: NewsDetails) {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(scrollState)
    ) {

        Text(
            fontSize = 24.sp,
            text = article.title,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .padding(8.dp)
        )

        CustomImage(
            imageUrl = article.imageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )


        Text(
            text = article.description,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = article.content,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(8.dp)
        )


        Text(
            text = "Published date: ${article.publishDate}",
            fontSize = 12.sp,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}
