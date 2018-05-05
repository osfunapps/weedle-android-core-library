package com.weedleapps.weedlelibraryproject.main.view

import android.os.Bundle
import com.weedleapps.weedlelib.modules.infrastructure.localrepository.LocalRepository
import com.weedleapps.weedlelib.modules.views.WeedleActivity


import javax.inject.Inject

import com.weedleapps.weedlelibraryproject.R
import com.weedleapps.weedlelibraryproject.main.presentation.MainActivityPresenterImpl


class MainActivity : WeedleActivity(), MainActivityView {

    @Inject lateinit var presenter: MainActivityPresenterImpl
    @Inject lateinit var localRepository: LocalRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.viewLoaded()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun presenterDone() {
        println("got msg: "+localRepository.getString("itzik"))
    }
}
