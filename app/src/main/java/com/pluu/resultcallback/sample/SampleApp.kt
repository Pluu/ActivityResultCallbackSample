package com.pluu.resultcallback.sample

import android.app.Application
import com.pluu.utils.ComponentLogger
import logcat.AndroidLogcatLogger
import logcat.LogPriority

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidLogcatLogger.installOnDebuggableApp(this, minPriority = LogPriority.VERBOSE)
        ComponentLogger().initialize(this)
    }
}