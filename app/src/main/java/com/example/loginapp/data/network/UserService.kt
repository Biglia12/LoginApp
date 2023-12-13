package com.example.loginapp.data.network

import android.util.Log
import com.example.loginapp.data.model.UserModel
import com.example.loginapp.data.model.UserRegisterResponse

class UserService(private val api: Api) {

    suspend fun callServiceRegister(hashMap: String, pass: String): UserRegisterResponse? {
        // return withContext(Dispatchers.IO) {
        try {
            val response = api.insertLoginService(hashMap, pass)
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
    // }

    suspend fun getUser(idUser: Int): UserModel? {
        val response = api.getUser(idUser)
        if (response.isSuccessful){
            return response.body()!!
        }
        return null
    /*    return withContext(Dispatchers.IO) {
            val response = api.getUser()
            response.body()!!
        }*/
    }
}