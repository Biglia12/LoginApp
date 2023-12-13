package com.example.loginapp.data.repository

import com.example.loginapp.data.model.LoginResponse
import com.example.loginapp.data.network.LoginService
import com.example.loginapp.domain.repository.LoginRepository

class LoginRepositoryImpl(private val loginService: LoginService) : LoginRepository {

    override suspend fun callServiceLogin(user: String, pass: String): LoginResponse? {
        val loginUser = loginService.callServiceLogin(user, pass)
       if (loginUser != null) {
            return loginUser
        }
        return null
    }

}