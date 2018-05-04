package com.weedleapps.weedlelib.modules

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weedleapps.weedlelib.R
import com.weedleapps.weedlelib.extensions.showToast
import com.weedleapps.weedlelib.modules.banks.*
import com.weedleapps.weedlelib.modules.behaviours.MessageView
import com.weedleapps.weedlelib.utils.crashreporter.CrashReporter
import com.weedleapps.weedlelib.utils.crashreporter.CrashReporterImpl

/**
 * Created by osapps on 01/05/2018.
 */
abstract class WeedleFragment: Fragment(), CrashReporter, MessageView {


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

    var currClass = javaClass.simpleName.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        reportCrashlyticsEvent(ON_CREATE + currClass)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        reportCrashlyticsEvent(ON_CREATE_VIEW + currClass)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        reportCrashlyticsEvent(ON_VIEW_CREATED + currClass)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStop() {
        reportCrashlyticsEvent(ON_STOP + currClass)
        super.onStop()
    }

    override fun onPause() {
        reportCrashlyticsEvent(ON_PAUSE + currClass)
        super.onPause()
    }

    override fun onDestroy() {
        reportCrashlyticsEvent(ON_DESTROY + currClass)
        super.onDestroy()
    }

    override fun onDestroyView() {
        reportCrashlyticsEvent(ON_DESTROY_VIEW + currClass)
        super.onDestroyView()
    }

    override fun onAttach(context: Context?) {
        reportCrashlyticsEvent(ON_ATTACH + currClass)
        super.onAttach(context)
    }

    override fun onDetach() {
        reportCrashlyticsEvent(ON_DETACH + currClass)
        super.onDetach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        reportCrashlyticsEvent(ON_SAVE_INSTANCE_STATE + currClass)
        super.onSaveInstanceState(outState)
    }


    override fun reportCrashlyticsEvent(event: String) {
        CrashReporterImpl.reportCrashlytics(event)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        reportCrashlyticsEvent(ON_ACTIVITY_RESULT + currClass)
        super.onActivityResult(requestCode, resultCode, data)
    }
}