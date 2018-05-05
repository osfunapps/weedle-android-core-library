package com.weedleapps.weedlelib.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import com.weedleapps.weedlelib.WeedleLibInitializer
import com.weedleapps.weedlelib.modules.infrastructure.localrepository.LocalRepository
import com.weedleapps.weedlelib.modules.infrastructure.localrepository.SharedPrefsLocalRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by osapps on 05/05/2018.
 */

@Module
class WeedleLibraryBuilder {

    //shared preferences
    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(WeedleLibInitializer.sharedPrefsName , Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideLocalRepository(prefs: SharedPreferences): LocalRepository {
        return SharedPrefsLocalRepository(prefs)
    }
}