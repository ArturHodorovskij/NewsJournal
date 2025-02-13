package com.example.newsjournal.presentation.design

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.presentation.ui.theme.defaultBackground

@Composable
fun LoginPage(navController: NavController) {
    val userEmail = remember { mutableStateOf("") }
    val userPassword = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TopAppBar(
            title = "Log in",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = {navController.navigate("HomePage")}
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
            text = "Enter password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        InputWindowInformation("Password",userPassword )

        TextButton(
            onClick = {navController.navigate("PasswordRecoveryPage")},
            modifier = Modifier

        ) {
            Text(
                text = "Forgot password?",
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                color = Color.Black
            )
        }

        ActionButton("Log in") { navController.navigate("HomePage") }

        Button(
            onClick = {},
            shape = RoundedCornerShape(15.dp),
            contentPadding = PaddingValues(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp,
                bottom = 8.dp
            ),
            border = BorderStroke(3.dp, Color.DarkGray),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = defaultBackground
            ),
            modifier = Modifier
                .padding(8.dp)
                .size(height = 48.dp, width = 240.dp)
        )
        {
            Image(
                modifier = Modifier
                    .size(24.dp),
                painter = painterResource(R.drawable.google),
                contentDescription = ""
            )
            Text(
                text = "Continue with google",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
        }
        Separator()

        Text(
            text = "Don't have NJ account?",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
        ActionButton("Create Account"){ navController.navigate("RegistrationPage") }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    LoginPage(navController = rememberNavController())
}