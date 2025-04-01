package com.example.newsjournal.presentation.screen.news

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.example.newsjournal.domain.models.Article


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun NewsScreenContentWebView(article: Article) {
    val url = article.url
    AndroidView(
        factory = {
            WebView(it).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        })
}

