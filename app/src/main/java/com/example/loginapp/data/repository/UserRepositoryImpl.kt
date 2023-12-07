package com.example.loginapp.data.repository

import android.util.Log
import com.example.loginapp.data.network.Api
import com.example.loginapp.domain.repository.UserRepository

class UserRepositoryImpl (private val api: Api): UserRepository {
    override suspend fun callServiceRegister(requestBody: HashMap<String,String>) {
        val response = api.callLogin(requestBody)
        if (response.isSuccessful){
            Log.i("ResponseUser", response.toString())
        }
    }

}