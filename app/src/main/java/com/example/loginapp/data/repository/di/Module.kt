package com.example.loginapp.data.repository.di

import com.example.loginapp.data.network.LoginService
import com.example.loginapp.data.repository.HomeRepositoryImpl
import com.example.loginapp.data.repository.LoginRepositoryImpl
import com.example.loginapp.data.repository.UserRepositoryImpl
import com.example.loginapp.domain.repository.HomeRepository
import com.example.loginapp.domain.repository.LoginRepository
import com.example.loginapp.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModules = module {
    single<UserRepository> {
        UserRepositoryImpl(userService = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userService = get())
    }

    single<LoginRepository> {
        LoginRepositoryImpl(loginService = get(), preferences = get())
    }
    single {
        LoginService(get())
    }

    single<LoginRepository> {
        LoginRepositoryImpl(loginService = get(), preferences = get())
    }
    single {
        LoginService(get())
    }

    single<HomeRepository> {
        HomeRepositoryImpl(preferences = get())
    }



}

/*val userRepositoryModules = module {
    single<UserRepository> {
        UserRepositoryImpl(userService = get())
    }

    single {
        UserService(get())
    }
}

val loginRespositoryModule = module {
    single<LoginRepository> {
        LoginRepositoryImpl(loginService = get(), preferences = get())
    }
    single {
        LoginService(get())
    }
}

val homeRepositoryModule = module {
    single<HomeRepository> {
        HomeRepositoryImpl(preferences = get())
    }*/

