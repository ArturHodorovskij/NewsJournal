package com.example.newsjournal.presentation.screen.news

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable

import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewModel(url: String) {
    AndroidView(
        factory = {
            WebView(it).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        })
}
