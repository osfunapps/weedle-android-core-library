package com.weedleapps.weedlelibraryproject.main.presentation

import com.weedleapps.weedlelib.modules.infrastructure.localrepository.LocalRepository
import com.weedleapps.weedlelibraryproject.main.view.MainActivityView

import javax.inject.Inject


class MainActivityPresenterImpl @Inject constructor(
        private var view: MainActivityView,
        private var localRepository: LocalRepository) {

    fun viewLoaded() {
        println("do some presenter initial stuff here")
        localRepository.saveString("itzik","fuck!")
        view.presenterDone()

    }

}