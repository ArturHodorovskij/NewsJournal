package com.example.newsjournal.presentation

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.presentation.favorite.FavoritePage
import com.example.newsjournal.presentation.home.HomeScreen
import com.example.newsjournal.presentation.autorization.PasswordRecoveryPage
import com.example.newsjournal.presentation.autorization.LoginPage
import com.example.newsjournal.presentation.autorization.NewPasswordPage
import com.example.newsjournal.presentation.autorization.PrivacyPolicyPage
import com.example.newsjournal.presentation.autorization.RegistrationPage
import com.example.newsjournal.presentation.tag.TagsPage
import com.example.newsjournal.presentation.tagcontent.TagContentScreen
import com.example.newsjournal.presentation.ui.theme.NewsJournalTheme

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
                        composable("HomePage") { HomeScreen(navController) }
                        composable("FavoritePage") { FavoritePage(navController) }
                        composable("TagsPage") { TagsPage(navController) }
                        composable("LoginPage") { LoginPage(navController) }
                        composable("PasswordRecoveryPage"){ PasswordRecoveryPage(navController) }
                        composable("RegistrationPage") { RegistrationPage(navController) }
                        composable("PrivacyPolicyPage"){ PrivacyPolicyPage(navController) }
                        composable("NewPasswordPage") { NewPasswordPage(navController) }
                        composable("TagContentScreen"){ TagContentScreen(navController) }
                }
            }
        }
    }
}