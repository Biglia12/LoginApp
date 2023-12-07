package com.example.loginapp.data.network.di

import com.example.loginapp.utils.Constants
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { createRetrofit(Constants.BASE_URL_LOGIN) }
}


fun createRetrofit(/*httpClient: OkHttpClient,*/ baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        //.client(httpClient)
        .build()
}