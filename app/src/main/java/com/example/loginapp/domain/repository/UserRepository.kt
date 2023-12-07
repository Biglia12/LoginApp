package com.example.loginapp.domain.repository

interface UserRepository {
    suspend fun callServiceRegister(hashMap: HashMap<String, String>): String
}