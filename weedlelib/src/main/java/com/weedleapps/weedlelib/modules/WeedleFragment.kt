package com.weedleapps.weedlelib.modules

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weedleapps.weedlelib.R
import com.weedleapps.weedlelib.banks.*
import com.weedleapps.weedlelib.extensions.showToast
import com.weedleapps.weedlelib.behaviours.MessageView
import com.weedleapps.weedlelib.behaviours.USER_MESSAGE
import com.weedleapps.weedlelib.parameters.reportCrashlytics
import dagger.android.support.DaggerFragment

/**
 * Created by osapps on 01/05/2018.
 */

/**
 * this class represents a weedle fragment.
 * it implements the crashlytics and a minor ui messaging system (using toast)
 **/
abstract class WeedleFragment: DaggerFragment(), MessageView {

    private val currClass = javaClass.simpleName.toString()


    //lif cycle
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        reportCrashlytics(ON_CREATE + currClass)
        super.onCreate(savedInstanceState)
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        reportCrashlytics(ON_CREATE_VIEW + currClass)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        reportCrashlytics(ON_VIEW_CREATED + currClass)
        super.onViewCreated(view, savedInstanceState)
    }

    @CallSuper
    override fun onStop() {
        reportCrashlytics(ON_STOP + currClass)
        super.onStop()
    }

    @CallSuper
    override fun onPause() {
        reportCrashlytics(ON_PAUSE + currClass)
        super.onPause()
    }

    @CallSuper
    override fun onDestroy() {
        reportCrashlytics(ON_DESTROY + currClass)
        super.onDestroy()
    }

    @CallSuper
    override fun onDestroyView() {
        reportCrashlytics(ON_DESTROY_VIEW + currClass)
        super.onDestroyView()
    }

    @CallSuper
    override fun onAttach(context: Context?) {
        reportCrashlytics(ON_ATTACH + currClass)
        super.onAttach(context)
    }

    @CallSuper
    override fun onDetach() {
        reportCrashlytics(ON_DETACH + currClass)
        super.onDetach()
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        reportCrashlytics(ON_SAVE_INSTANCE_STATE + currClass)
        super.onSaveInstanceState(outState)
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