package com.example.loginapp.data.network

import android.util.Log
import com.example.loginapp.data.model.LoginResponse
import com.example.loginapp.data.model.UserRegisterResponse

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

}