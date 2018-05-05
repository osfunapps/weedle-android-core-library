package com.weedleapps.weedlelibraryproject.main.di

import com.weedleapps.weedlelib.dagger.scopes.PerActivity
import com.weedleapps.weedlelib.modules.infrastructure.localrepository.LocalRepository
import com.weedleapps.weedlelibraryproject.main.presentation.MainActivityPresenterImpl
import com.weedleapps.weedlelibraryproject.main.view.MainActivity
import com.weedleapps.weedlelibraryproject.main.view.MainActivityView

import dagger.Module
import dagger.Provides

/**
 * This module holds all of the instances related to MainActivity.
 * In order to inject specific instance into the fragment, we need to:
 * check out DetailFragmentModule to read more about how to use this kind of module (it's basically the same)
 */

@Module
class MainActivityModule {

    //the main activity view
    @Provides
    fun provideMainView(mainActivity: MainActivity) : MainActivityView = mainActivity

    /**
     * notice that the presenter of this activity needs a the MainActivityView and an ItztikInstace to initialize itself.
     * the method above provides the MainActivityView and ItztikInstance isn't provided by no one (cause the only argument
     * it takes has a blank builder i.e doesn't require any special arguments to be initialized).
     *
     * This rule of thumb is true for all of the provided instances, in all of the modules: if an instance
     * doesn't take any argument or takes instances with a blank constructor, we don't need to provide it.
     * Dagger will provide it in runtime. This is true for ItzikInstance.
     */

    @Provides
    @PerActivity
    fun provideMainPresenter(mainActivityView: MainActivityView, localRepository: LocalRepository): MainActivityPresenterImpl {
        return MainActivityPresenterImpl(mainActivityView, localRepository)
    }


}
