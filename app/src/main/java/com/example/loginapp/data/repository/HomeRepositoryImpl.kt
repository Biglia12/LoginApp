package com.example.loginapp.data.repository

import com.example.loginapp.domain.repository.HomeRepository
import com.example.loginapp.data.preferences.SharedPreferences

class HomeRepositoryImpl(private val preferences: SharedPreferences): HomeRepository {

    override fun getJwt(): String? {
        return preferences.getJwt()
    }
}