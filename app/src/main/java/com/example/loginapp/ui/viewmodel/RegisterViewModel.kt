package com.example.loginapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.loginapp.domain.repository.UserRepository


class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun callServiceUser(requestBody: HashMap<String, String>) {
        try {
            println("algo")
            /* viewModelScope.launch {
                 userRepository.callServiceRegister(requestBody)
             }*/
        } catch (_: Exception) {


        }
    }

}