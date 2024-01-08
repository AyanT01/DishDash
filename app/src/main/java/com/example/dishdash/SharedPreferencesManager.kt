package com.example.dishdash

import android.content.Context

object SharedPreferencesManager {
    private const val USER_PREFERENCES = "user_preferences"
    private const val first_name = "username"
    private const val last_name = "lastname"
    // other keys...

    fun saveUserData(context: Context, key:String, value:String) {
        val editor = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE).edit()
        editor.putString(key, value)
        // Save other user data...
        editor.apply()
    }

    fun getUserData(context: Context, key:String): String? {
        val sharedPreferences = context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)
        val value = sharedPreferences.getString(key, null)
        return value

    }
    fun clear(context:Context) {
        val sharedPreferences = context.getSharedPreferences(USER_PREFERENCES,Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
    }
}
