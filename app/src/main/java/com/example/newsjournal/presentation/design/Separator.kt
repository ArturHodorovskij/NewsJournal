package com.example.newsjournal.presentation.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newsjournal.presentation.ui.theme.separatorColor

@Composable
fun Separator(){
    Box (modifier = Modifier
        .height(1.dp)
        .background(color = separatorColor)
        .fillMaxWidth())
}