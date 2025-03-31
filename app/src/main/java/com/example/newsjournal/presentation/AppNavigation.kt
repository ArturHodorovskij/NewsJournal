package com.example.newsjournal.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.presentation.screen.news.NewsScreen
import com.example.newsjournal.presentation.screen.autorization.LoginScreen
import com.example.newsjournal.presentation.screen.autorization.NewPasswordScreen
import com.example.newsjournal.presentation.screen.autorization.PasswordRecoveryScreen
import com.example.newsjournal.presentation.screen.autorization.PrivacyPolicyScreen
import com.example.newsjournal.presentation.screen.autorization.RegistrationScreen
import com.example.newsjournal.presentation.screen.favorite.FavoriteScreen
import com.example.newsjournal.presentation.screen.home.HomeScreen
import com.example.newsjournal.presentation.screen.tag.TagsScreen
import com.example.newsjournal.presentation.screen.tagcontent.TagContentScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomePage") {
        composable("HomePage") { HomeScreen(navController) }
        composable("FavoritePage") { FavoriteScreen(navController) }
        composable("TagsPage") { TagsScreen(navController) }
        composable("LoginPage") { LoginScreen(navController) }
        composable("PasswordRecoveryPage") { PasswordRecoveryScreen(navController) }
        composable("RegistrationPage") { RegistrationScreen(navController) }
        composable("PrivacyPolicyPage") { PrivacyPolicyScreen(navController) }
        composable("NewPasswordPage") { NewPasswordScreen(navController) }
        composable("NewsScreen") {
            NewsScreen(navController)
        }

        composable("TagContentScreen" + "/{tag}") { stackEntry ->
            val tag = stackEntry.arguments?.getString("tag")
            TagContentScreen(navController, tag)
        }
    }
}