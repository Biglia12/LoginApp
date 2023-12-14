package com.example.loginapp.domain.usecase

import com.example.loginapp.data.network.entities.response.LoginResponse
import com.example.loginapp.domain.repository.LoginRepository

class LoginUseCase(private val repository: LoginRepository) {

    suspend fun login(user: String, pass: String): LoginResponse? {
        val login = repository.callServiceLogin(user, pass)
        if (login != null) {
            return login
        }

        return null
    }

}