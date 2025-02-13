package com.example.newsjournal.presentation.feed



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
import com.example.newsjournal.presentation.design.BottomAppBar
import com.example.newsjournal.presentation.design.FavoritePage
import com.example.newsjournal.presentation.design.HomePage
import com.example.newsjournal.presentation.design.PasswordRecoveryPage
import com.example.newsjournal.presentation.design.LoginPage
import com.example.newsjournal.presentation.design.NewPasswordPage
import com.example.newsjournal.presentation.design.PrivacyPolicyPage
import com.example.newsjournal.presentation.design.RegistrationPage
import com.example.newsjournal.presentation.design.Separator
import com.example.newsjournal.presentation.design.TagsPage
import com.example.newsjournal.presentation.design.TopAppBar
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

