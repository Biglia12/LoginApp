package com.example.loginapp.data.repository

import android.util.Log
import com.example.loginapp.data.network.Api
import com.example.loginapp.domain.repository.UserRepository

class UserRepositoryImpl(private val api: Api) : UserRepository {
    override suspend fun callServiceRegister(user: String, pass: String): String {
        try {
            val response = api.callLogin(user, pass)
            if (response.isSuccessful) {
                return response.body().toString()
                Log.i("ResponseUser", response.toString())
            }else{
                Log.e("ErrorUser", "Error en la llamada al servicio: ${response.message()}")
            }

        } catch (e: Exception) {
            Log.e("ErrorUser", "Error en la llamada al servicio: ", e)
            return "error"
        }
        return "error"
    }

}