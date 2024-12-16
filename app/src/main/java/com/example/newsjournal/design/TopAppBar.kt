package com.example.newsjournal.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.R
import com.example.newsjournal.ui.theme.defaultBackground

@Composable
fun TopAppBar(
    startImage: Painter? = null,
    title: String,
    endImage: Painter? = null,
    startImageClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(defaultBackground),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (startImage != null) {
            Image(
                modifier = Modifier
                    .size(48.dp)
                    .padding(horizontal = 8.dp)
                    .clickable { startImageClick() },
                painter = startImage,
                contentDescription = ""
            )
        }

        Text(
            text = title,
            fontSize = 24.sp,
            textAlign = TextAlign.Start
        )

        if (endImage != null) {
            Image(
                modifier = Modifier
                    .size(48.dp)
                    .padding(horizontal = 8.dp),
                painter = endImage,
                contentDescription = ""
            )
        } else {
            Box(modifier = Modifier.width(48.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryTopAppbarPreview() {
    TopAppBar(
        startImage = painterResource(R.drawable.person2),
        endImage = painterResource(R.drawable.star1),
        title = "title",
        startImageClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun SecondaryTopAppbarPreview() {
    TopAppBar(
        startImage = painterResource(R.drawable.person2),
        endImage = null,
        title = "Title",
        startImageClick = {}
    )
}