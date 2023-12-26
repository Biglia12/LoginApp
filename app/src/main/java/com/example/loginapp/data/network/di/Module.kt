package com.example.loginapp.data.network.di

import com.example.loginapp.data.network.Api
import com.example.loginapp.data.network.LoginService
import com.example.loginapp.data.network.UserService
import com.example.loginapp.data.preferences.SharedPreferences
import com.example.loginapp.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createFirstRetrofit(Constants.BASE_URL_LOGIN) }

    //single { createRetrofit(Constants.BASE_URL_LOGIN) }
    single {
        UserService(get())
    }

    single {
        LoginService(get())
    }

    single {
        createRetrofit(get())
    }

}

fun createRetrofit(preferences: SharedPreferences): Api {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val token = preferences.getJwt()// Implementa esta función según cómo almacenes el token localmente

            val newRequest = if (token != null) {
                originalRequest.newBuilder()
                    .header("Authorization", "Bearer $token")
                    .build()
            } else {
                originalRequest
            }

            chain.proceed(newRequest)
        }
        .readTimeout(45, TimeUnit.SECONDS)
        .build()

    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(Constants.BASE_URL_LOGIN)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)
}

fun createFirstRetrofit(baseUrl: String): Api {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(ScalarsConverterFactory.create()) //important
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .build()
        .create(Api::class.java)
}

fun gson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}
