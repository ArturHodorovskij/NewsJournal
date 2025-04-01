package com.example.newsjournal.presentation.screen.news

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable

import androidx.compose.ui.viewinterop.AndroidView
import com.example.newsjournal.domain.models.TopStories

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun NewsScreenContentWebView(topStories: TopStories) {
    topStories.results.forEach { it ->
        val url =  it.url
    AndroidView(
        factory = {
            WebView(it).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        })
}
}
