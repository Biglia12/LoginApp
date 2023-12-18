package com.example.loginapp.data.repository

import com.example.loginapp.data.network.entities.response.LoginResponse
import com.example.loginapp.data.network.LoginService
import com.example.loginapp.domain.repository.LoginRepository
import com.example.loginapp.preferences.SharedPreferences

class LoginRepositoryImpl(private val loginService: LoginService, private val preferences: SharedPreferences) : LoginRepository {

    override suspend fun callServiceLogin(user: String, pass: String): LoginResponse? {
        val loginUser = loginService.callServiceLogin(user, pass)
       if (loginUser != null) {
            preferences.setJwt(loginUser.token)
            return loginUser
        }
        return null
    }

    override suspend fun isValidToken(): Boolean {
        val token = preferences.getJwt()
        return if (token.isNullOrEmpty()) {
            false
        } else {
            loginService.isValidToken(token)
        }
    }

}