package com.example.newsjournal.design


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.example.newsjournal.R

@Composable
fun NewPasswordPage() {

    val useremail = remember { mutableStateOf("") }
    val userpassword = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(title = "Change password",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = {}
        )

        Separator()

        Text(
            text = "Enter email",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        InputWindowInformation("Email",useremail )

        Text(
            text = "Enter the verification code",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        InputWindowInformation("Password",userpassword )

        Text(
            text = "Create new password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        InputWindowInformation("Password",userpassword )

        Spacer(modifier = Modifier.height(16.dp))

        ActionButton("Continue")
    }
}


@Preview(showBackground = true)
@Composable
fun NewPasswordPagePreview() {
    NewPasswordPage()
}