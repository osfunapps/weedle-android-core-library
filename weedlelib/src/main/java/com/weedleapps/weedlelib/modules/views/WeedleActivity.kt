package com.weedleapps.weedlelib.modules.views

import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import com.weedleapps.weedlelib.R
import com.weedleapps.weedlelib.banks.*
import com.weedleapps.weedlelib.extensions.ui.showToast
import com.weedleapps.weedlelib.behaviours.MessageView
import com.weedleapps.weedlelib.behaviours.USER_MESSAGE
import com.weedleapps.weedlelib.parameters.reportCrashlytics
import dagger.android.support.DaggerAppCompatActivity


/**
 * Created by osapps on 04/05/2018.
 */

 /**
 * this class represents a weedle activity.
 * it implements the crashlytics and a minor ui messaging system (using toast)
 **/

abstract class WeedleActivity: DaggerAppCompatActivity(), MessageView {


    private val currClass = javaClass.simpleName.toString()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        reportCrashlytics(ON_CREATE + currClass)
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onResume() {
        reportCrashlytics(ON_RESUME + currClass)
        super.onResume()
    }

    @CallSuper
    override fun onBackPressed() {
        reportCrashlytics(ON_BACK_PRESSED + currClass)
        super.onBackPressed()
    }

    @CallSuper
    override fun onPause() {
        reportCrashlytics(ON_PAUSE + currClass)
        super.onPause()
    }

    @CallSuper
    override fun onStop() {
        reportCrashlytics(ON_STOP + currClass)
        super.onStop()
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle?) {
        reportCrashlytics(ON_SAVE_INSTANCE_STATE + currClass)
        super.onSaveInstanceState(outState)
    }


    @CallSuper
    override fun onDestroy() {
        reportCrashlytics(ON_DESTROY + currClass)
        super.onDestroy()
    }

    @CallSuper
    override fun finish() {
        reportCrashlytics(ON_FINISH + currClass)
        super.finish()

    }

    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        reportCrashlytics(ON_ACTIVITY_RESULT + currClass)
        super.onActivityResult(requestCode, resultCode, data)
    }

    //messages
    override fun showMessage(resId: Int) {
        showToast(resId)
        reportCrashlytics(USER_MESSAGE + getString(resId))
    }

    override fun showMessage(message: String) {
        showToast(message)
        reportCrashlytics(USER_MESSAGE + message)

    }

    override fun showGenericErrorMessage() {
        showMessage(R.string.msg_generic_error)
        reportCrashlytics(USER_MESSAGE + getString(R.string.msg_generic_error))
    }

}