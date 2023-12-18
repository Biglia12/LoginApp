package com.example.loginapp.data.network

import com.example.loginapp.data.network.entities.response.LoginResponse
import com.example.loginapp.data.network.entities.response.TokenResponse
import com.example.loginapp.data.network.entities.response.UserModel
import com.example.loginapp.data.network.entities.response.UserRegisterResponse
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
     @POST("loguear.php")
     suspend fun loginService(@Field ("nombre") nombre: String, @Field ("pass") pass: String): Response<LoginResponse>

     @FormUrlEncoded
     @POST("validateToken.php")
     suspend fun validToken(@Field ("token") token: String): Response<ResponseBody>


}