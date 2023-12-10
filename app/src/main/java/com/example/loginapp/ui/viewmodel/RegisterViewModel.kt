package com.example.loginapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapp.domain.repository.UserRepository
import com.example.loginapp.domain.usecase.UserUseCase
import kotlinx.coroutines.launch


class RegisterViewModel(private val userUseCase: UserUseCase/*private val userRepository: UserRepository*/) : ViewModel() {

    val messageResponse: LiveData<String> get() = _messageResponse
    private val _messageResponse= MutableLiveData<String>()

    fun callServiceUser(user: String, pass: String) {
        //println("algo")
        viewModelScope.launch {
            val messageApi = userUseCase(user, pass)
            _messageResponse.postValue(messageApi)
        }
    }


}