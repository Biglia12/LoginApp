package com.example.loginapp.data.preferences.di

import com.example.loginapp.domain.usecase.UserUseCase
import com.example.loginapp.data.preferences.SharedPreferences
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single {
        SharedPreferences(get())
    }
}