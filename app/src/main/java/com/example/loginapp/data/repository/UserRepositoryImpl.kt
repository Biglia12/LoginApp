package com.example.loginapp.data.repository

import com.example.loginapp.data.model.UserModel
import com.example.loginapp.data.model.UserResponseRegisterModel
import com.example.loginapp.data.network.UserService
import com.example.loginapp.domain.repository.UserRepository

class UserRepositoryImpl(private val userService: UserService) : UserRepository {

    override suspend fun callServiceRegister(user: String, pass: String): UserResponseRegisterModel {
        val user = userService.callServiceRegister(user, pass)
        return user!!
    }

    override suspend fun getServiceUser(idUser: Int): UserModel {
        val user = userService.getUser(idUser)
        return user!!
    }

}