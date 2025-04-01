package com.example.newsjournal.presentation.screen.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.domain.models.Article
import com.example.newsjournal.presentation.design.CustomImage
import com.example.newsjournal.presentation.design.Separator

@Composable
fun NewsScreenContent(article: Article) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .padding(8.dp)
    ) {
        CustomImage(
            imageUrl = article.multimedia?.firstOrNull()?.url,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(
            fontSize = 16.sp,
            text = article.multimedia!!.first().copyright,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .padding(8.dp)
        )

        Text(
            fontSize = 16.sp,
            text = article.title,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .padding(8.dp)
        )

        Text(
            text = article.abstract,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = article.byline,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp)
        )

        Text(
            text = article.publishedDate!!,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp)
        )
        Separator()
    }
}
