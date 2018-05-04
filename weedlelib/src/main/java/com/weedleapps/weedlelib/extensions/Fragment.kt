package com.weedleapps.weedlelib.extensions

import android.app.Activity
import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

/**
 * Created by osapps on 04/05/2018.
 */

//show messages
fun Fragment.showToast(@StringRes resource: Int, duration: Int = Toast.LENGTH_SHORT) = showToast(getString(resource), duration)
fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(context, message, duration).show()
