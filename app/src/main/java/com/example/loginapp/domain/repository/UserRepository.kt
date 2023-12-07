package com.example.loginapp.domain.repository

interface UserRepository {
    suspend fun callServiceRegister(hashMap: String, pass: String): String
}