package com.example.newsjournal.design

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.R

@Composable
fun ScrollContentWindow(
    contentimage: Painter? = null,
    contenttitle: String,
    contentdescription: String
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Top,

            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .clickable { }
        ) {

            if (painterResource(R.drawable.home_24) != null) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    painter = painterResource(R.drawable.home_24),
                    contentDescription = ""
                )
            }

            Text(fontSize = 28.sp,
                text = contenttitle

            )
            Text(text = contentdescription)
        }
    }

}



@Preview(showBackground = true)
@Composable
fun PrimaryContentLine() {
    ScrollContentWindow(
        contentimage = null,
        contenttitle = "Сказка про колобка",
        contentdescription = "— Испеки, старуха, колобок.\n" +
                "\n" +
                "— Из чего испечь-то? Муки нет.\n" +
                "\n" +
                "— Эх, старуха! По коробу поскреби, по сусеку помети; авось муки и наберется."
    )
}