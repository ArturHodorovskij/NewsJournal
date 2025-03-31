package com.example.newsjournal.presentation.screen.news

import android.annotation.SuppressLint
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewModel(url: String) {
    val loading = remember { mutableStateOf(true) }

    Column(Modifier.fillMaxSize()) {
        if (loading.value) {
            LinearProgressIndicator(Modifier.fillMaxSize())
        }

        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView?, url: String?) {
                            loading.value = false
                        }
                    }
                    loadUrl(url)
                }
            },
            modifier = Modifier.weight(1f) // Занимает оставшееся пространство
        )
    }
}