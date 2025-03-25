package com.example.newsjournal.presentation.screen.tagcontent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TagContentScreenError(errorMessage: TagContentScreenState.Error) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "$errorMessage try again later",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(8.dp))
    }
}

