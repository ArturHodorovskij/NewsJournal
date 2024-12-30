package com.example.newsjournal.design

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsjournal.R
import com.example.newsjournal.ui.theme.defaultBackground

@Composable
fun RegistrationPage() {
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
            startImageClick = {}
        )
        Text(
            text = "Enter email",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
        Box(
            modifier = Modifier
                .border(width = 2.dp, color = Color.Gray)
                .size(height = 56.dp, width = 240.dp)
        ) {
            TextField(
                value = useremail.value,
                onValueChange = { newText -> useremail.value = newText },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = defaultBackground,
                    unfocusedTextColor = Color(0xff888888),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0xff222222)
                ),
                textStyle = TextStyle(fontSize = 16.sp),
                placeholder = { Text(text = "Email") },
                modifier = Modifier
                    .size(height = 56.dp, width = 240.dp)
            )
        }
        Text(
            text = "Create password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
        Box(
            modifier = Modifier
                .border(width = 2.dp, color = Color.Gray)
                .size(height = 56.dp, width = 240.dp)
        ) {
            TextField(
                value = userpassword.value,
                onValueChange = { newText -> userpassword.value = newText },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = defaultBackground,
                    unfocusedTextColor = Color(0xff888888),
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color(0xff222222)
                ),
                textStyle = TextStyle(fontSize = 16.sp),
                placeholder = { Text(text = "Password") },
                modifier = Modifier
                    .size(height = 56.dp, width = 240.dp)
            )
        }
        TextButton(
            onClick = {},
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
        Button(
            onClick = {},
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(3.dp, Color.DarkGray),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black
            ),
            modifier = Modifier
                .size(height = 48.dp, width = 240.dp)
        ) {
            Text("Create Account", fontSize = 16.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegistrationPagePreview() {
    RegistrationPage()
}