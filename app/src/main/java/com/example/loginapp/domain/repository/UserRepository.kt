package com.example.loginapp.domain.repository

interface UserRepository {
    suspend fun callServiceRegister(requestBody: HashMap<String, String>)
}