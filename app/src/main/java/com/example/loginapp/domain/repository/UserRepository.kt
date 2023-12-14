package com.example.loginapp.domain.repository

import com.example.loginapp.data.network.entities.response.UserModel
import com.example.loginapp.data.network.entities.response.UserRegisterResponse

interface UserRepository {
    suspend fun callServiceRegister(user: String, pass: String): UserRegisterResponse?

    suspend fun getServiceUser(idUser: Int): UserModel
}