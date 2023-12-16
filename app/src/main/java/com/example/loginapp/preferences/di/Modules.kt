package com.example.loginapp.preferences.di

import com.example.loginapp.domain.usecase.UserUseCase
import com.example.loginapp.preferences.SharedPreferences
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single {
        SharedPreferences(get())
    }
}