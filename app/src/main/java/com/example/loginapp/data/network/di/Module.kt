package com.example.loginapp.data.network.di

import com.example.loginapp.data.network.Api
import com.example.loginapp.data.network.UserService
import com.example.loginapp.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

val networkModule = module {
    single { createRetrofit(Constants.BASE_URL_LOGIN) }

    single {
        UserService(get())
    }
}




fun createRetrofit(baseUrl: String): Api {
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
