package com.example.multilanguage

import android.content.Context

val PREFERENCE_NAME="SharedPreferenceExample"
val PREFERENCE_LANGUAGE = "Language"
class MyPreference(context: Context) {

    val preference= context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun getPreferenceLanguage(): String{
        return preference.getString(PREFERENCE_LANGUAGE,"en").toString()
    }

    fun setPreferenceLanguage(language:String){
        val editor=preference?.edit()
        editor?.putString(PREFERENCE_LANGUAGE,language)
        editor?.apply()
    }
}