package com.example.loginapp.domain.di

import com.example.loginapp.domain.usecase.HomeUseCase
import com.example.loginapp.domain.usecase.LoginUseCase
import com.example.loginapp.domain.usecase.UserUseCase
import org.koin.dsl.module

val domainModule = module {
    single {
        UserUseCase(get())
    }

    single {
        LoginUseCase(get())
    }

    single {
        HomeUseCase(get())
    }
}

/*val userUseCaseModule = module {
    single {
        UserUseCase(get())
    }
}
val loginUseCaseModule = module {
    single {
        LoginUseCase(get())
    }
}
val homeUseCaseModule = module {
    single {
        HomeUseCase(get())
    }
}*/
