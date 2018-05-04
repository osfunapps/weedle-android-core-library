package com.weedleapps.weedlelib.modules

import android.content.Intent
import android.os.Bundle
import com.weedleapps.weedlelib.R
import com.weedleapps.weedlelib.modules.banks.*
import com.weedleapps.weedlelib.modules.behaviours.MessageView
import com.weedleapps.weedlelib.extensions.showToast
import com.weedleapps.weedlelib.utils.crashreporter.CrashReporter
import com.weedleapps.weedlelib.utils.crashreporter.CrashReporterImpl
import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by osapps on 04/05/2018.
 */

abstract class WeedleActivity: DaggerAppCompatActivity(), CrashReporter, MessageView {

    private val currClass = javaClass.simpleName.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        reportCrashlyticsEvent(ON_CREATE + currClass)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        reportCrashlyticsEvent(ON_RESUME + currClass)
        super.onResume()
    }

    override fun onBackPressed() {
        reportCrashlyticsEvent(ON_BACK_PRESSED + currClass)
        super.onBackPressed()
    }


    override fun onPause() {
        reportCrashlyticsEvent(ON_PAUSE + currClass)
        super.onPause()
    }

    override fun onStop() {
        reportCrashlyticsEvent(ON_STOP + currClass)
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        reportCrashlyticsEvent(ON_SAVE_INSTANCE_STATE + currClass)
        super.onSaveInstanceState(outState)
    }


    override fun onDestroy() {
        reportCrashlyticsEvent(ON_DESTROY + currClass)
        super.onDestroy()
    }

    override fun finish() {
        reportCrashlyticsEvent(ON_FINISH + currClass)
        super.finish()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        reportCrashlyticsEvent(ON_ACTIVITY_RESULT + currClass)
        super.onActivityResult(requestCode, resultCode, data)
    }

    //messages
    override fun showMessage(resId: Int) {
        showToast(resId)
        reportCrashlyticsEvent(USER_MESSAGE + getString(resId))
    }

    override fun showMessage(message: String) {
        showToast(message)
        reportCrashlyticsEvent(USER_MESSAGE + message)

    }

    override fun showGenericErrorMessage() {
        showMessage(R.string.msg_generic_error)
        reportCrashlyticsEvent(USER_MESSAGE + getString(R.string.msg_generic_error))
    }

    override fun reportCrashlyticsEvent(event: String) = CrashReporterImpl.reportCrashlytics(event)



}