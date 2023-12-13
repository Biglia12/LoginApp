package com.example.loginapp.domain.repository

interface LoginRepository {

    suspend fun callServiceLogin()
}