package com.example.loginapp.domain.usecase

import com.example.loginapp.data.model.UserRegisterResponse
import com.example.loginapp.data.network.UserService

class LoginUseCase(private val userService: UserService) {

    suspend fun login(user: String, pass: String): UserRegisterResponse? {
        val user = repository.callServiceRegister(user, pass)
        if (user != null) {
            return user
        }

        return null
    }

}