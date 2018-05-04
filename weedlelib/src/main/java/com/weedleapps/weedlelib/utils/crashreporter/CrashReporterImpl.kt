package com.weedleapps.weedlelib.utils.crashreporter

import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

/**
 * Created by osapps on 01/05/2018.
 */
object CrashReporterImpl {

    fun reportCrashlytics(msg: String) {
        if(Fabric.isInitialized()) Crashlytics.log(msg)
    }
}

