package com.example.loginapp.data.preferences

import android.app.Activity
import android.content.Context

class SharedPreferences (context: Context) {

    private val sharedPref = context.getSharedPreferences(APP, 0)

    companion object {
        const val TOKEN = "TOKEN_LOGIN"
        const val APP = "App"
    }

    fun setJwt(jwt: String?) {
        val editor = sharedPref.edit()
        editor.putString(TOKEN, jwt)
        editor.apply()
    }

    fun getJwt(): String? {
        return sharedPref.getString(TOKEN, null)
    }

}