package com.example.loginapp.domain.repository

interface UserRepository {
    suspend fun callServiceRegister(nombre: String, pass: String): String
}