package com.example.loginapp.data.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.FieldMap
import retrofit2.http.POST

interface Api {

     @POST("insertar.php")
     suspend fun callLogin(@FieldMap fields: HashMap<String, String>): Response<String>

}