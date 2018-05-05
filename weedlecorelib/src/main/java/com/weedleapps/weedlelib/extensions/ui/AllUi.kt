package com.weedleapps.weedlelib.extensions.ui

import android.view.View

/**
 * Created by osapps on 05/05/2018.
 */

//change views visibility
fun setViewsVisibility(visibility: Int, vararg views: View) {
    views.forEach { it.visibility = visibility }
}