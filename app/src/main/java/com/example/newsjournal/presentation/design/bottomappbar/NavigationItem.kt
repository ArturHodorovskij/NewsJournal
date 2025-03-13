package com.example.newsjournal.presentation.design.bottomappbar

import androidx.compose.ui.graphics.painter.Painter

data class NavigationItem(
    val key: String,
    val imageItem: Painter?,
    val nameItem: String
)
