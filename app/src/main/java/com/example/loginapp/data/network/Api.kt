package com.example.loginapp.data.network

import com.example.loginapp.data.model.UserModel
import com.example.loginapp.data.model.UserRegisterResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

     @FormUrlEncoded
     @POST("insertar.php")
     suspend fun insertLoginService(@Field ("nombre") nombre: String, @Field ("pass") pass: String): Response<UserRegisterResponse>

     @GET("registro.php")
     suspend fun getUser(idUser: Int): Response<UserModel>

     @FormUrlEncoded
     @POST("logueo.php")
     suspend fun loginService(@Field ("nombre") nombre: String, @Field ("pass") pass: String): Response<ResponseBody>

}