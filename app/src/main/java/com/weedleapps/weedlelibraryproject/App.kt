package com.weedleapps.weedlelibraryproject

import com.crashlytics.android.Crashlytics
import com.weedleapps.weedlelib.LibInitializer
import com.weedleapps.weedlelibraryproject.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.fabric.sdk.android.Fabric


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
        Fabric.with(this, Crashlytics())
        LibInitializer.withFabric = true
        super.onCreate()
    }
}
