package com.example.loginapp.domain.usecase

import com.example.loginapp.data.model.UserModel
import com.example.loginapp.data.model.UserRegisterResponse
import com.example.loginapp.domain.repository.UserRepository

class UserUseCase(private val repository: UserRepository) {

    suspend fun registerUSer(user: String, pass: String): UserRegisterResponse? {
        val user = repository.callServiceRegister(user, pass)
        if (user != null) {
            return user
        }

        return null
    }

    suspend fun getUser(idUser: Int): UserModel {
        val user = repository.getServiceUser(idUser)
        return user
    }

}