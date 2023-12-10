package com.example.loginapp.domain.usecase

import com.example.loginapp.domain.repository.UserRepository

class UserUseCase (private val respository: UserRepository) {

    suspend operator fun invoke(user: String, pass: String): String {
        val user = respository.callServiceRegister(user, pass)
        return user
    }

}