package com.weedleapps.weedlelibraryproject.main.view

import android.os.Bundle
import com.weedleapps.weedlelib.modules.WeedleActivity


import javax.inject.Inject

import com.weedleapps.weedlelibraryproject.R
import com.weedleapps.weedlelibraryproject.main.presentation.MainActivityPresenterImpl


class MainActivity : WeedleActivity(), MainActivityView {

    @Inject
    lateinit var presenter: MainActivityPresenterImpl


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.viewLoaded()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun presenterDone() {
        println("view done")
    }
}
