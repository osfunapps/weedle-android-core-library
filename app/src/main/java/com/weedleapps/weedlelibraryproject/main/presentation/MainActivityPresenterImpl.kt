package com.weedleapps.weedlelibraryproject.main.presentation

import com.weedleapps.weedlelibraryproject.main.view.MainActivityView

import javax.inject.Inject


class MainActivityPresenterImpl @Inject constructor(private var view: MainActivityView) {

    fun viewLoaded() {
        println("do some presenter initial stuff here")

        view.presenterDone()

    }

}