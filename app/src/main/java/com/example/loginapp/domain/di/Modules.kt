package com.example.loginapp.domain.di

import com.example.loginapp.domain.usecase.LoginUseCase
import com.example.loginapp.domain.usecase.UserUseCase
import org.koin.dsl.module

val userUseCaseModule = module {
    single {
        UserUseCase(get())
    }
}
val loginUseCaseModule = module {
    single {
        LoginUseCase(get())
    }
}
