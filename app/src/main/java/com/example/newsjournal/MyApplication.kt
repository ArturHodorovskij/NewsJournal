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
            LeakCanary.config //TODO хз или правильно подключил

            //if (LeakCanary.isInAnalyzerProcess(this)) {
            //
            //      return;
            //    }
            //    LeakCanary.install(this);
            //
            //  } TODO чат гпт и гемини пишут такое, но почему то инсталл не работает и исИнАналузерПроцесс
        }
    }
}
