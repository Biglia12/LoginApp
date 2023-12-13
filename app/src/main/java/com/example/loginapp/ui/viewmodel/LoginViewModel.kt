package com.example.loginapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapp.domain.usecase.LoginUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(val loginUseCase: LoginUseCase) : ViewModel() {

    val messageResponse: LiveData<String> get() = _messageResponse
    private val _messageResponse = MutableLiveData<String>()

    val progressBar: LiveData<Boolean> get() = _progressBar
    private val _progressBar = MutableLiveData<Boolean>()
    val errorService: LiveData<Boolean> get() = _errorService
    private val _errorService = MutableLiveData<Boolean>()
    val userLogued: LiveData<Boolean> get() = _userLogued
    private val _userLogued = MutableLiveData<Boolean>()

    fun callServiceLogin(user: String, pass: String) {
        //println("algo")
        viewModelScope.launch {
            _progressBar.postValue(true)
            delay(2000)
            val apiRegister = loginUseCase.login(user, pass)
            if (apiRegister != null) {
                if (!apiRegister.error) {
                    _messageResponse.postValue(apiRegister.message)
                    _userLogued.postValue(true)
                } else {
                    _messageResponse.postValue(apiRegister.message)
                    _userLogued.postValue(false)
                }
            } else {
                _errorService.postValue(true)
            }
            _progressBar.postValue(false)
            //val getUser = userUseCase.getUser(idUser)
            //println(getUser)// es para obtener el usuario
        }
    }

}