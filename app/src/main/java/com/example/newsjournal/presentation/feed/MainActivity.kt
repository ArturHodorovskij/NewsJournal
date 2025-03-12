package com.example.newsjournal.presentation.feed

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
import com.example.newsjournal.presentation.design.FavoritePage
import com.example.newsjournal.presentation.design.HomePage
import com.example.newsjournal.presentation.design.PasswordRecoveryPage
import com.example.newsjournal.presentation.design.LoginPage
import com.example.newsjournal.presentation.design.NewPasswordPage
import com.example.newsjournal.presentation.design.PrivacyPolicyPage
import com.example.newsjournal.presentation.design.RegistrationPage
import com.example.newsjournal.presentation.design.TagsPage
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
                        composable("HomePage") { HomePage(navController) }
                        composable("FavoritePage") { FavoritePage(navController) }
                        composable("TagsPage") { TagsPage(navController) }
                        composable("LoginPage") { LoginPage(navController) }
                        composable("PasswordRecoveryPage"){ PasswordRecoveryPage(navController) }
                        composable("RegistrationPage") { RegistrationPage(navController) }
                        composable("PrivacyPolicyPage"){ PrivacyPolicyPage(navController) }
                        composable("NewPasswordPage") { NewPasswordPage(navController) }
                }
            }
        }
    }
}
