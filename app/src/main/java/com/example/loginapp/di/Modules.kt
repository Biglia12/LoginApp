package com.example.loginapp.di


import com.example.loginapp.data.network.Api
import com.example.loginapp.data.network.UserService
import com.example.loginapp.data.repository.UserRepositoryImpl
import com.example.loginapp.domain.repository.UserRepository
import com.example.loginapp.domain.usecase.UserUseCase
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

    // Declara el RegisterViewModel con la dependencia de UserRepository
    viewModel {
        RegisterViewModel(get())
    }
}

