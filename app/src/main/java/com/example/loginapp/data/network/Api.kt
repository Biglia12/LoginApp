package com.example.loginapp.data.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

     @FormUrlEncoded
     @POST("insertar.php")
     suspend fun callLogin(@Field ("nombre") nombre: String, @Field ("pass") pass: String): Response<String>

}