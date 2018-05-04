package com.weedleapps.weedlelib.utils.crashreporter

/**
 * Created by osapps on 01/05/2018.
 */
interface CrashReporter {

    fun reportCrashlyticsEvent(event: String)
}