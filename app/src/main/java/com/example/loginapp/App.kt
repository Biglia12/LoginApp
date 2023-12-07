package com.example.loginapp

import android.app.Application
import com.example.loginapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }



    private fun setupKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(appModule)
            //androidLogger(Level.ERROR)
            //androidContext(app)
            //modules(appModules)
        }

    }
}