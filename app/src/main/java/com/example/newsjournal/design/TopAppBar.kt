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
            .height(100.dp)
            .background(defaultBackground)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        if (startImage != null) {
            Image(
                modifier = Modifier
                    .size(32.dp)
                    .clickable { startImageClick() },
                painter = startImage,
                contentDescription = ""
            )
        }

        Text(
            text = title,
            fontSize = 28.sp,
            textAlign = TextAlign.Start
        )

        if (endImage != null) {
            Image(
                modifier = Modifier
                    .size(32.dp),
                painter = endImage,
                contentDescription = ""
            )
        } else {
            Box(modifier = Modifier.width(32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryTopAppbarPreview() {
    TopAppBar(
        startImage = painterResource(R.drawable.person_24),
        endImage = painterResource(R.drawable.star_24),
        title = "title",
        startImageClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun SecondaryTopAppbarPreview() {
    TopAppBar(
        startImage = painterResource(R.drawable.person_24),
        endImage = null,
        title = "Title",
        startImageClick = {}
    )
}