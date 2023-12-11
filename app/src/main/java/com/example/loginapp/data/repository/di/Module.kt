package com.example.loginapp.data.repository.di

import com.example.loginapp.data.network.UserService
import com.example.loginapp.data.repository.UserRepositoryImpl
import com.example.loginapp.domain.repository.UserRepository
import org.koin.dsl.module


val userRepositoryModules = module {
    single<UserRepository> {
        UserRepositoryImpl(userService = get())
    }

    single {
        UserService(get())
    }
}
