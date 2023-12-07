package com.example.loginapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.loginapp.data.repository.UserRepository


class RegisterViewModel (private val userRepository: UserRepository): ViewModel() {
    fun callServiceUser () {
        userRepository.callServiceRegister()
    }

}