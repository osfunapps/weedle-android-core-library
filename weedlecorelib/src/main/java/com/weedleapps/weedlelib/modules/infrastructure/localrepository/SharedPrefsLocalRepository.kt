package com.weedleapps.weedlelib.modules.infrastructure.localrepository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.weedleapps.weedlelib.modules.infrastructure.types.ListParameterizedType
import com.weedleapps.weedlelib.modules.infrastructure.types.PairParameterizedType


class SharedPrefsLocalRepository(private val preferences: SharedPreferences) : LocalRepository {

    //setters
    override fun saveString(key: String, value: String?) = preferences.edit().putString(key, value).apply()
    override fun saveBool(key: String, value: Boolean) = preferences.edit().putBoolean(key, value).apply()
    override fun saveInt(key: String, int: Int) = preferences.edit().putInt(key, int).apply()

    //getters
    override fun getString(key: String): String? = preferences.getString(key, null)
    override fun getInt(key: String): Int = preferences.getInt(key, 0)
    override fun getBool(key: String): Boolean = preferences.getBoolean(key, false)


    //generic getters and setters
    override fun <T> getArrayListObject(key: String, clazz: Class<T>) : ArrayList<T>? {
        val str =  preferences.getString(key, "")
        if(str == "")return null
        val type = ListParameterizedType(clazz)
        return Gson().fromJson(str, type)
    }

    override fun <T, E> getPair(key: String, firstObj: Class<T>, secondObj: Class<E>): Pair<T, E>? {
        val str =  preferences.getString(key, "")
        if(str == "")return null
        val type = PairParameterizedType(firstObj, secondObj)
        return Gson().fromJson(str, type)
    }

    override fun <T> saveObject(key: String, value: T?) {
        val json = Gson().toJson(value)
        preferences.edit().putString(key, json).apply()
    }

    //etc
    override fun removeKey(key: String) = preferences.edit().remove(key).apply()



}