package com.weedleapps.weedlelib.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import com.weedleapps.weedlelib.modules.infrastructure.localrepository.LocalRepository
import com.weedleapps.weedlelib.modules.infrastructure.localrepository.SharedPrefsLocalRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by osapps on 05/05/2018.
 */

@Module
class LibraryAppModule{

    //shared preferences
    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences("sp", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideLocalRepository(prefs: SharedPreferences): LocalRepository {
        return SharedPrefsLocalRepository(prefs)
    }
}