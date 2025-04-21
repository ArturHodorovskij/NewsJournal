package com.example.newsjournal

import android.app.Application
import com.squareup.leakcanary.core.BuildConfig
import leakcanary.LeakCanary
import timber.log.Timber

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        if (BuildConfig.DEBUG) {
            LeakCanary.config
        }
    }
}
