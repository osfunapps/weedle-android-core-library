package com.weedleapps.weedlelib.extensions

import android.app.Activity
import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

/**
 * Created by osapps on 04/05/2018.
 */


//keyboard handling
fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.RESULT_UNCHANGED_SHOWN)
}

//show messages
fun Activity.showToast(@StringRes resource: Int, duration: Int = Toast.LENGTH_SHORT) = showToast(getString(resource), duration)
fun Activity.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show()

//clear all back stack
fun AppCompatActivity.popEntireBackStack() {
    if(supportFragmentManager.backStackEntryCount>0)
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}