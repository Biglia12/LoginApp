package com.example.loginapp.domain.repository

import com.example.loginapp.data.network.entities.response.LoginResponse

interface LoginRepository {
    suspend fun callServiceLogin(user: String, pass: String): LoginResponse?
    suspend fun isValidToken(): Boolean?
}