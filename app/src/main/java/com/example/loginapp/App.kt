package com.example.loginapp

import android.app.Application
import com.example.loginapp.data.network.di.networkModule
import com.example.loginapp.data.repository.di.homeRepositoryModule
import com.example.loginapp.data.repository.di.loginRespositoryModule
import com.example.loginapp.data.repository.di.userRepositoryModules
import com.example.loginapp.di.appModule
import com.example.loginapp.domain.di.homeUseCaseModule
import com.example.loginapp.domain.di.loginUseCaseModule
import com.example.loginapp.domain.di.userUseCaseModule
import com.example.loginapp.preferences.di.sharedPreferencesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }



    private fun setupKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(appModule, userUseCaseModule,
                loginUseCaseModule, userRepositoryModules,
                loginRespositoryModule, networkModule,
                sharedPreferencesModule, homeUseCaseModule,homeRepositoryModule)
            //modules(appModule, userUseCaseModule,userRepositoryModules, networkModule)
            //androidLogger(Level.ERROR)
            //androidContext(app)
            //modules(appModules)
        }

    }
}