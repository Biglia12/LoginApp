package com.example.loginapp.data.network

import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

     @POST("insertar.php")
     suspend fun callLogin(@Body fields : JSONObject): Response<String>

}