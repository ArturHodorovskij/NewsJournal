package com.example.newsjournal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.ui.theme.NewsJournalTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsJournalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoadingPage(
                    )
                }
            }
        }
    }
}


@Composable
fun LogoText() {
    Text(
        text = "NJ",
        fontSize = 80.sp,
        fontFamily = FontFamily.Serif,
        lineHeight = 150.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .border(width = 6.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
            .padding(10.dp)
    )
}

@Composable
fun LoadingPage() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        LogoText()
    }
}

//////////////////////////////////////////////////////////////////////////////
@Composable
fun TopLine() {
    val loginIcon = painterResource(R.drawable.person2)
    Row() {
        Box(
            modifier = Modifier
                .background(Color(0xFFC0C0C0))
                .height(80.dp)
                .weight(1f)
        ) {
            BarNavigationItem(loginIcon)
        }

        Box(
            modifier = Modifier
                .background(Color(0xFFC0C0C0))
                .height(80.dp)
                .weight(3f)
        )
        {
            Text(
                text = "NEWS JOURNAL",
                fontSize = 26.sp,
                lineHeight = 80.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight(550),
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .background(Color(0xFFC0C0C0))
                .height(80.dp)
                .weight(1f)
        )
    }
}


@Composable
fun MidlLine() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Text(
            text = "News",
            fontSize = 36.sp,

//            textAlign = TextAlign.End   а схуя это оно тут так не работает как вверху?
            modifier = Modifier
                .padding(16.dp)
                .clickable {  }

        )
    }
}

@Composable
fun DownLine() {
    val homeIcon = painterResource(R.drawable.home1)
    val saveIcon = painterResource(R.drawable.star1)
    val tagsIcon = painterResource(R.drawable.tagscollection1)
    Row() {
        Box(
            modifier = Modifier
                .background(Color(0xFFC0C0C0))
                .height(80.dp)
                .weight(1f)
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC0C0C0))
            ) {
                Image(
                    painter = homeIcon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .weight(1f)
                        .align(alignment = Alignment.CenterVertically)
                )
            }
        }
        Box(
            modifier = Modifier
                .background(Color(0xFFC0C0C0))
                .height(80.dp)
                .weight(1f)
        )
        {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC0C0C0))
            ) {
                Image(
                    painter = saveIcon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .weight(1f)
                )
            }
        }
        Box(
            modifier = Modifier
                .background(Color(0xFFC0C0C0))
                .height(80.dp)
                .weight(1f)
        )
        {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC0C0C0))

            ) {
                Image(
                    painter = tagsIcon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
fun HomePage() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Box(modifier = Modifier.weight(1f)) {
            TopLine()
        }
        Box(modifier = Modifier.weight(9f)) {
            MidlLine()
        }

        Box(modifier = Modifier.weight(1f)) {
            DownLine()
        }
    }
}

@Composable
fun BarNavigationItem(image: Painter) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC0C0C0))
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
        )
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    NewsJournalTheme {
//        LoadingPage()
//    }
//}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    NewsJournalTheme {
        HomePage()
    }
}