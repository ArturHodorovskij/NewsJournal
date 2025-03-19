package com.example.newsjournal.presentation.design.bottomappbar

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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R

@Composable
fun BottomAppBar(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(0.5.dp )
            .height(80.dp)
            .padding(vertical = 8.dp, horizontal = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
    ) {

        for (item in initNavigationBarItems()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { navController.navigate(item.key) }
            ) {
                if (item.imageItem != null) {
                    Image(
                        modifier = Modifier
                            .size(32.dp),
                        painter = item.imageItem,
                        contentDescription = null
                    )

                    Text(
                        text = item.nameItem
                    )
                }
            }
        }
    }
}

@Composable
private fun initNavigationBarItems(): List<NavigationItem> = listOf(
    NavigationItem(
        key = "HomePage",
        imageItem = painterResource(R.drawable.home_24),
        nameItem = "Home"
    ),
    NavigationItem(
        key = "FavoritePage",
        imageItem = painterResource(R.drawable.collections_bookmark_24),
        nameItem = "Favorite"
    ),
    NavigationItem(
        key = "TagsPage",
        imageItem = painterResource(R.drawable.list_alt_24dp),
        nameItem = "Tags"
    )
)

@Preview(showBackground = true)
@Composable
fun PrimaryBotAppbarPreview() {
    BottomAppBar(
        navController = rememberNavController()
    )
}