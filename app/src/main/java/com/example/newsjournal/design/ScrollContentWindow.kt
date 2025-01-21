package com.example.newsjournal.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.R

@Composable
fun ScrollContentWindow(
    contentImage: Painter? = null,
    contentTitle: String,
    contentDescription: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { }
        ) {
            if (contentImage != null) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    painter = contentImage,
                    contentDescription = ""
                )
            }

            Text(
                fontSize = 28.sp,
                text = contentTitle
            )

            Text(text = contentDescription)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryContentLine() {
    ScrollContentWindow(
        contentImage = painterResource(R.drawable.home_24),
        contentTitle = "Сказка про колобка",
        contentDescription = "— Испеки, старуха, колобок.\n" +
                "\n" +
                "— Из чего испечь-то? Муки нет.\n" +
                "\n" +
                "— Эх, старуха! По коробу поскреби, по сусеку помети; авось муки и наберется."
    )
}