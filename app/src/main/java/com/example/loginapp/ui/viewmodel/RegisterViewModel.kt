package com.example.loginapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapp.domain.usecase.UserUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class RegisterViewModel(private val userUseCase: UserUseCase/*private val userRepository: UserRepository*/) : ViewModel() {

    val messageResponse: LiveData<String> get() = _messageResponse
    private val _messageResponse= MutableLiveData<String>()

    val progressBar: LiveData<Boolean> get() = _progressBar
    private val _progressBar= MutableLiveData<Boolean>()

    private var idUser: Int = 0

    fun callServiceUser(user: String, pass: String) {
        //println("algo")
        viewModelScope.launch {
            _progressBar.postValue(true)
            delay(5000)
            val apiRegister = userUseCase.registerUSer(user, pass)
            if (apiRegister != null) {
                _messageResponse.postValue(apiRegister.message)
                _progressBar.postValue(false)
                //idUser = apiRegister.id
            }
            _progressBar.postValue(false)
            //val getUser = userUseCase.getUser(idUser)
            //println(getUser)// es para obtener el usuario
        }
    }


}