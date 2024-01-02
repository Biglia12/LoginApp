package com.example.loginapp.ui.viewmodel.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapp.domain.usecase.LoginUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel (private val useCase: LoginUseCase): ViewModel() {

    val tokenValidated: LiveData<Boolean> get() = _tokenValidated
    private val _tokenValidated= MutableLiveData<Boolean>()

     fun validToken(){
        viewModelScope.launch {
            delay(1000)
            if (useCase.isValidToken()!!) {
                Log.i("token", "respondio bien")
                _tokenValidated.value = true
            } else {
                Log.i("token", "respondio mal")
                _tokenValidated.value = false
            }
        }

    }

}