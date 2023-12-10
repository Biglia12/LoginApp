package com.example.loginapp.data.network

import android.util.Log

class UserService (private val api: Api) {

    suspend fun callServiceRegister(hashMap: String, pass: String): String {
       // return withContext(Dispatchers.IO) {
            try {
                val response = api.callLogin(hashMap, pass)
                if (response.isSuccessful) {
                    return response.body()!!
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
   // }

}