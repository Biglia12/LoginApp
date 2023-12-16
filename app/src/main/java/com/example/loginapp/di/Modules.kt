package com.example.loginapp.di


import com.example.loginapp.ui.viewmodel.Home.HomeViewModel
import com.example.loginapp.ui.viewmodel.LoginViewModel
import com.example.loginapp.ui.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Declara el RegisterViewModel con la dependencia de UserRepository
    viewModel {
        RegisterViewModel(get())
    }

    viewModel {
        LoginViewModel(get())
    }

    viewModel {
        HomeViewModel(get())
    }
}

