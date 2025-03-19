package com.example.newsjournal.presentation

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
import com.example.newsjournal.presentation.screen.autorization.LoginScreen
import com.example.newsjournal.presentation.screen.autorization.NewPasswordScreen
import com.example.newsjournal.presentation.screen.autorization.PasswordRecoveryScreen
import com.example.newsjournal.presentation.screen.autorization.PrivacyPolicyScreen
import com.example.newsjournal.presentation.screen.autorization.RegistrationScreen
import com.example.newsjournal.presentation.screen.favorite.FavoriteScreen
import com.example.newsjournal.presentation.screen.home.HomeScreen
import com.example.newsjournal.presentation.screen.tag.TagsScreen
import com.example.newsjournal.presentation.screen.tagcontent.TagContentScreen
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
                    composable("FavoritePage") { FavoriteScreen(navController) }
                    composable("TagsPage") { TagsScreen(navController) }
                    composable("LoginPage") { LoginScreen(navController) }
                    composable("PasswordRecoveryPage") { PasswordRecoveryScreen(navController) }
                    composable("RegistrationPage") { RegistrationScreen(navController) }
                    composable("PrivacyPolicyPage") { PrivacyPolicyScreen(navController) }
                    composable("NewPasswordPage") { NewPasswordScreen(navController) }
                    composable("TagContentScreen" + "/{tag}") { stackEntry ->

                        val tag = stackEntry.arguments?.getString("tag")

                        TagContentScreen(navController, tag)
                    }
                }
            }
        }
    }
}