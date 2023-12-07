package com.example.loginapp.di


import com.example.loginapp.data.network.Api
import com.example.loginapp.data.repository.UserRepositoryImpl
import com.example.loginapp.domain.repository.UserRepository
import com.example.loginapp.ui.viewmodel.RegisterViewModel
import com.example.loginapp.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

val appModule = module {
    // Declara el retrofit como un singleton directamente
    single { createRetrofit(Constants.BASE_URL_LOGIN) }

    // Declara el RegisterViewModel con la dependencia de UserRepository
    viewModel {
        RegisterViewModel(userRepository = get())
    }

    // Declara el UserRepository con la implementación proporcionada por UserRepositoryImpl
    single<UserRepository> {
        UserRepositoryImpl(api = get())
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
