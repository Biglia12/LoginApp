package com.example.loginapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapp.domain.usecase.UserUseCase
import kotlinx.coroutines.launch


class RegisterViewModel(private val userUseCase: UserUseCase/*private val userRepository: UserRepository*/) : ViewModel() {

    val messageResponse: LiveData<String> get() = _messageResponse
    private val _messageResponse= MutableLiveData<String>()

    private var idUser: Int = 0

    fun callServiceUser(user: String, pass: String) {
        //println("algo")
        viewModelScope.launch {
            val apiRegister = userUseCase.registerUSer(user, pass)
            if (apiRegister != null) {
                _messageResponse.postValue(apiRegister.message)
                //idUser = apiRegister.id
            }

            //val getUser = userUseCase.getUser(idUser)
            //println(getUser)// es para obtener el usuario
        }
    }


}