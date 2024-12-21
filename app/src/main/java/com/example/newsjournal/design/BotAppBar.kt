package com.example.newsjournal.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsjournal.R
import com.example.newsjournal.ui.theme.defaultBackground

@Composable
fun BotAppBar(
    firstImage: Painter? = null,
    secondImage: Painter? = null,
    thirdImage: Painter? = null,
    text1Image: String,
    text2Image: String,
    text3Image: String,
    startImageClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(defaultBackground)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (firstImage != null) {
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { startImageClick() },
                    painter = firstImage,
                    contentDescription = ""
                )
                Text(
                    text = text1Image
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (secondImage != null) {
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { startImageClick() },
                    painter = secondImage,
                    contentDescription = ""
                )
                Text(
                    text = text2Image
                )
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (thirdImage != null) {
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { startImageClick() },
                    painter = thirdImage,
                    contentDescription = ""
                )
            }
            Text(
                text = text3Image
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PrimaryBotAppbarPreview() {
    BotAppBar(
        firstImage = painterResource(R.drawable.home1),
        secondImage = painterResource(R.drawable.star1),
        thirdImage = painterResource(R.drawable.tagscollection1),
        startImageClick = {},
        text1Image = "Home",
        text2Image = "Favorite",
        text3Image = "Tags"
    )
}
