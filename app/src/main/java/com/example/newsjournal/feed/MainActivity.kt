package com.example.newsjournal.feed


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.design.BottomAppBar
import com.example.newsjournal.design.FavoritePage
import com.example.newsjournal.design.PasswordRecoveryPage
import com.example.newsjournal.design.LoginPage
import com.example.newsjournal.design.NewPasswordPage
import com.example.newsjournal.design.PrivacyPolicyPage
import com.example.newsjournal.design.RegistrationPage
import com.example.newsjournal.design.Separator
import com.example.newsjournal.design.TagsPage
import com.example.newsjournal.design.TopAppBar
import com.example.newsjournal.ui.theme.NewsJournalTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            NewsJournalTheme {
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    ) {
                    NavHost(navController = navController, startDestination = "HomePage") {
                        composable("HomePage") { HomePage(navController) }
                        composable("FavoritePage") { FavoritePage(navController) }
                        composable("TagsPage") { TagsPage(navController) }
                        composable( "LoginPage") { LoginPage(navController) }
                        composable("PasswordRecoveryPage"){ PasswordRecoveryPage(navController) }
                        composable("RegistrationPage") { RegistrationPage(navController) }
                        composable("PrivacyPolicyPage"){ PrivacyPolicyPage(navController) }
                        composable("NewPasswordPage") { NewPasswordPage(navController) }

                }
            }
        }
    }
}

@Composable
fun HomePage(navController:NavController) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = "NEWS JOURNAL",
            startImage = painterResource(R.drawable.person_24),
            startImageClick = {navController.navigate("LoginPage")}
        )
        Separator()
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier
                .weight(1f)
        ) {
            item {
                Text(
                    text = stringResource(R.string.news),
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { }
                )
            }
        }
        Separator()
        BottomAppBar(
            firstImage = painterResource(R.drawable.home_24),
            secondImage = painterResource(R.drawable.collections_bookmark_24),
            thirdImage = painterResource(R.drawable.list_alt_24dp),
            text1Image = "Home",
            text2Image = "Favorite",
            text3Image = "Tags",
            navController = navController
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    HomePage(navController = rememberNavController())
}