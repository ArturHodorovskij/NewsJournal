package com.example.newsjournal.presentation.design

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import com.example.newsjournal.data.retrofit.topStoriesApi.TopStoriesResponse


@Composable
fun ScrollContentWindow(articles: LiveData<TopStoriesResponse?>) {
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier

    ) {
        items(articles) {art->
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { }
            ) {

//                    if (contentImage != null) {
//                        Image(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(200.dp),
//                            painter = contentImage,
//                            contentDescription = ""
//                        )
//                    }
                Text(
                    fontSize = 28.sp,
                    text = "${article.results}"
                )

                Text(text = "${article.abstract}")
            }
        }
    }
}


//    contentImage: Painter? = null,
//    contentTitle: String?,
//    contentDescription: String?

//@Preview(showBackground = true)
//@Composable
//fun PrimaryContentLine() {
//    ScrollContentWindow(
////        contentImage = painterResource(R.drawable.home_24),
//        contentTitle = "хуй",
//        contentDescription = "— Испеки, старуха, колобок.\n" +
//                "\n" +
//                "— Из чего испечь-то? Муки нет.\n" +
//                "\n" +
//                "— Эх, старуха! По коробу поскреби, по сусеку помети; авось муки и наберется."
//    )
//}
