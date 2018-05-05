package com.weedleapps.weedlelib.parameters

import com.weedleapps.weedlelib.LibInitializer
import com.weedleapps.weedlelib.utils.crashreporter.CrashReporterImpl

/**
 * Created by osapps on 05/05/2018.
 */

/** this file holds the crashlytics command which got implemented into the Activity and Fragment classes **/


//report crashlytics command
val reportCrashlytics: (log: String) -> Unit =
        when {
            LibInitializer.withFabric == null -> throw RuntimeException("set LibInitializer.withFabric = to true or false")
            LibInitializer.withFabric!! -> CrashReporterImpl::reportCrashlytics
            else -> ::emptyFunc
        }

private fun emptyFunc(str: String =""){}
