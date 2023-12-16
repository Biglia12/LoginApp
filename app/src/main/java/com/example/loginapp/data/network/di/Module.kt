package com.example.loginapp.data.network.di

import com.example.loginapp.data.network.Api
import com.example.loginapp.data.network.LoginService
import com.example.loginapp.data.network.UserService
import com.example.loginapp.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.Route
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
}

/*fun createRetrofit(baseUrlLogin: String): Retrofit {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    val okHttpClient = OkHttpClient.Builder()
        .authenticator { route: Route?, response: Response ->
            response.request().newBuilder().header("Authorization", "Bearer $token").build()
        }
        .readTimeout(45, TimeUnit.SECONDS) // socket timeout
        .addInterceptor(interceptor)
        .addInterceptor { chain: Interceptor.Chain ->
            val request = chain.request().newBuilder()
                .header("Magazine-EndUser", "magazine")
                .header("Authorization", "Bearer $token")
                .build()
            chain.proceed(request)
        }.build()

    return Retrofit.Builder().client(okHttpClient)
        .baseUrl(com.q4tech.magazine.Model.MagApplication.MONAPPLIVIDURIAPI)
        .addConverterFactory(GsonConverterFactory.create()).build()

}*/


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
