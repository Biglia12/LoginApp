package com.example.loginapp.domain.usecase

import com.example.loginapp.data.model.UserModel
import com.example.loginapp.data.model.UserResponseRegisterModel
import com.example.loginapp.domain.repository.UserRepository

class UserUseCase (private val repository: UserRepository) {

    suspend fun registerUSer(user: String, pass: String): UserResponseRegisterModel {
        val user = repository.callServiceRegister(user, pass)
        return user
    }

    suspend fun getUser(idUser: Int): UserModel {
        val user = repository.getServiceUser(idUser)
        return user
    }

}