package com.example.loginapp.ui.viewmodel.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapp.domain.usecase.LoginUseCase
import kotlinx.coroutines.launch

class SplashViewModel (private val useCase: LoginUseCase): ViewModel() {

     fun validToken(){
        viewModelScope.launch {
            if (useCase.isValidToken()!!) {
                Log.i("token", useCase.isValidToken().toString())
            } else {
                Log.i("token", useCase.isValidToken().toString())
            }
        }

    }

}