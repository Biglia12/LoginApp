package com.example.loginapp.data.network

import com.example.loginapp.data.model.UserModel
import com.example.loginapp.data.model.UserResponseRegisterModel
import com.example.loginapp.ui.viewmodel.RegisterViewModel
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

     @FormUrlEncoded
     @POST("insertar.php")
     suspend fun callLogin(@Field ("nombre") nombre: String, @Field ("pass") pass: String): Response<UserResponseRegisterModel>

     @GET("registro.php")
     suspend fun getUser(idUser: Int): Response<UserModel>

}