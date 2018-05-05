package com.weedleapps.weedlelibraryproject


import com.weedleapps.weedlelib.WeedleLibInitializer
import com.weedleapps.weedlelibraryproject.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


/**
 * Created by osApps on 25/05/2017.
 */

class App : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        //build the app component
        val appComponent = DaggerAppComponent.builder().application(this).build()

        //inject the app into it
        appComponent.inject(this)

        //return the app component
        return appComponent
    }

    override fun onCreate() {
        WeedleLibInitializer.withFabric = false
        WeedleLibInitializer.sharedPrefsName = "spp"
        super.onCreate()

    }
}
