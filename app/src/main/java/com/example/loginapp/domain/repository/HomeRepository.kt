package com.example.loginapp.domain.repository

interface HomeRepository {
    fun getJwt(): String?
}