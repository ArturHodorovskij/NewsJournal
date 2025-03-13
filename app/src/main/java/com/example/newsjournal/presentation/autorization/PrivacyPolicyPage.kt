package com.example.newsjournal.presentation.autorization


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.newsjournal.R
import com.example.newsjournal.presentation.design.Separator
import com.example.newsjournal.presentation.design.TopAppBar

@Composable
fun PrivacyPolicyPage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = "Privacy policy",
            startImage = painterResource(R.drawable.reply_24),
            startImageClick = {navController.navigate("RegistrationPage")}
        )
        Separator()
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier
                .weight(1f)
        ) {
            item {
                Text(
                    text = stringResource(R.string.privacy_policy),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PrivacyPolicyPreview() {
    PrivacyPolicyPage(navController = rememberNavController())
}