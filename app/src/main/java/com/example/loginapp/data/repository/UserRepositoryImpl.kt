package com.example.loginapp.data.repository

import com.example.loginapp.data.model.UserModel
import com.example.loginapp.data.model.UserResponseRegisterModel
import com.example.loginapp.data.network.UserService
import com.example.loginapp.domain.repository.UserRepository
import com.example.loginapp.utils.ThrowException

class UserRepositoryImpl(private val userService: UserService) : UserRepository {

    override suspend fun callServiceRegister(user: String, pass: String): UserResponseRegisterModel? {
        val user = userService.callServiceRegister(user, pass)
        if (user != null) {
            return user
        }
        return null
    }

    override suspend fun getServiceUser(idUser: Int): UserModel {
        val user = userService.getUser(idUser)
        return user!!
    }

}