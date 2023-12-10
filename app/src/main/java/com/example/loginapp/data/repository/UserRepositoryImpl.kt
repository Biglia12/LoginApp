package com.example.loginapp.data.repository

import com.example.loginapp.data.network.UserService
import com.example.loginapp.domain.repository.UserRepository

class UserRepositoryImpl(private val userService: UserService) : UserRepository {

    override suspend fun callServiceRegister(hashMap: String, pass: String): String {
        val user = userService.callServiceRegister(hashMap, pass)
        return user
    }

}