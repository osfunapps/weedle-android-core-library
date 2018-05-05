package com.weedleapps.weedlelib.modules.infrastructure.localrepository

interface LocalRepository{

    /**
     * a shared prefs handler module.
     * to use, insert into your app module these 2 providers:


    //shared preferences impl
    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences {
    return context.getSharedPreferences("sp", Context.MODE_PRIVATE)
    }

    //shared preferences
    @Provides
    @Singleton
    fun provideLocalRepository(prefs: SharedPreferences): LocalRepository {
    return SharedPrefsLocalRepository(prefs)
    }

     * then just inject the LocalRepository to any class which needs the shared prefs
     */

    //getters
    fun getString(key: String): String?
    fun getBool(key: String): Boolean
    fun getInt(key: String): Int

    //setters
    fun saveBool(key: String, value: Boolean)
    fun saveString(key: String, value: String?)
    fun saveInt(key: String, int: Int)

    //generics
    fun <T> saveObject(key: String, value: T?)
    fun <T> getArrayListObject(key: String, clazz: Class<T>) : ArrayList<T>?
    fun <T, E> getPair(key: String, firstObj: Class<T>, secondObj: Class<E>): Pair<T, E>?

    //cleaner
    fun removeKey(key: String)
}