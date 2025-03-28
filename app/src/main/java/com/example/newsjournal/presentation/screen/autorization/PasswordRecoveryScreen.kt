package com.example.newsjournal.presentation.screen.autorization


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.presentation.design.ActionButton
import com.example.newsjournal.presentation.design.InputWindowInformation
import com.example.newsjournal.presentation.design.Separator
import com.example.newsjournal.presentation.design.TopAppBar

@Composable
fun PasswordRecoveryScreen(navController: NavController) {
    val userEmail = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "Password recovery",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = {navController.navigate("LoginPage")}
        )

        Separator()

        Text(
            text = "Enter email",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        InputWindowInformation("Email",userEmail )

        Text(
            text = "The recovery code will be sent to your email address",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(16.dp)
        )

        ActionButton("Send code"){navController.navigate("NewPasswordPage")}
    }
}


@Preview(showBackground = true)
@Composable
fun ForgotPasswordPagePreview() {
    PasswordRecoveryScreen(navController = rememberNavController())
}