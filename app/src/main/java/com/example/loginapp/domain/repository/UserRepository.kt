package com.example.loginapp.domain.repository

import com.example.loginapp.data.model.UserModel
import com.example.loginapp.data.model.UserResponseRegisterModel

interface UserRepository {
    suspend fun callServiceRegister(user: String, pass: String): UserResponseRegisterModel

    suspend fun getServiceUser(idUser: Int): UserModel
}