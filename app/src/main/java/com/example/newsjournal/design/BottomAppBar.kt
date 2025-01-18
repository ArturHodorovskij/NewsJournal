package com.example.newsjournal.design

import androidx.compose.foundation.Image
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R


@Composable
fun BottomAppBar(navController:NavController,
    firstImage: Painter? = null,
    secondImage: Painter? = null,
    thirdImage: Painter? = null,
    text1Image: String,
    text2Image: String,
    text3Image: String

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 8.dp, horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,

        ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable {  navController.navigate("HomePage")}
        ) {
            if (firstImage != null) {
                Image(
                    modifier = Modifier
                        .size(32.dp),
                    painter = firstImage,
                    contentDescription = ""
                )
                Text(
                    text = text1Image
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable { navController.navigate("FavoritePage")}
        ) {
            if (secondImage != null) {
                Image(
                    modifier = Modifier
                        .size(32.dp),
                    painter = secondImage,
                    contentDescription = ""
                )
                Text(
                    text = text2Image
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable {navController.navigate("TagsPage") }
        ) {
            if (thirdImage != null) {
                Image(
                    modifier = Modifier
                        .size(32.dp),
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
    BottomAppBar(
        firstImage = painterResource(R.drawable.home_24),
        secondImage = painterResource(R.drawable.collections_bookmark_24),
        thirdImage = painterResource(R.drawable.list_alt_24dp),
        text1Image = "Home",
        text2Image = "Favorite",
        text3Image = "Tags",
        navController = rememberNavController()

    )
}
