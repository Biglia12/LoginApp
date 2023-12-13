package com.example.loginapp.domain.repository

import com.example.loginapp.data.model.LoginResponse

interface LoginRepository {
    suspend fun callServiceLogin(user: String, pass: String): LoginResponse?
}