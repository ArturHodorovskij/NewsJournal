package com.example.newsjournal.design


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R

@Composable
fun RegistrationPage(navController: NavController) {
    val useremail = remember { mutableStateOf("") }
    val userpassword = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "Register",
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
        InputWindowInformation("Email",useremail )
        Text(
            text = "Create password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
        InputWindowInformation("Password",userpassword )
        TextButton(
            onClick = {navController.navigate("PrivacyPolicyPage")},
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "By creating an account, you agree to the Privacy Policy.",
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
        ActionButton("Create Account"){navController.navigate("HomePage")}
    }
}


@Preview(showBackground = true)
@Composable
fun RegistrationPagePreview() {
    RegistrationPage(navController = rememberNavController())
}