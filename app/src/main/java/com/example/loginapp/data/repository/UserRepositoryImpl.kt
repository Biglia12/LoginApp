package com.example.loginapp.data.repository

import android.util.Log
import com.example.loginapp.data.network.Api
import com.example.loginapp.domain.repository.UserRepository

class UserRepositoryImpl(private val api: Api) : UserRepository {
    override suspend fun callServiceRegister(nombre: String, pass: String): String {
        val response = api.callLogin(nombre, pass)
        if (response.isSuccessful) {
            return response.body().toString()
            Log.i("ResponseUser", response.toString())
        }
        return "error"

    }

}