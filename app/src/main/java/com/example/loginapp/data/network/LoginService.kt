package com.example.loginapp.data.network

import android.util.Log
import com.example.loginapp.data.network.entities.response.LoginResponse

class LoginService(private val api: Api) {

    suspend fun callServiceLogin(user: String, pass: String): LoginResponse? {
        // return withContext(Dispatchers.IO) {
        try {
            val response = api.loginService(user, pass)
            if (response.isSuccessful) {
                return response.body()
                Log.i("ResponseUser", response.toString())
            } else {
                Log.e("ErrorUser", "Error en la llamada al servicio: ${response.message()}")
            }

        } catch (e: Exception) {
            Log.e("ErrorUser", "Error en la llamada al servicio: ", e)
            return null
        }
        return null
    }

    suspend fun isValidToken(token: String): Boolean {
        try {
        val response = api.validToken(token)
        Log.i("token", response.toString())
            if (response.isSuccessful) {
                Log.i("token", response.toString())
                return true
            }
            ///return requireNotNull(response?.valid)
        } catch (e: Exception) {
            Log.i("errorValidToke",e.toString())
        }
        return false
    }


}