package com.example.loginapp.ui.viewmodel.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginapp.domain.usecase.HomeUseCase
class HomeViewModel (private val homeUseCase: HomeUseCase) : ViewModel() {

    val jwt: LiveData<String> get() = _jwt
    private val _jwt= MutableLiveData<String>()

    fun getJwt() {
        val jwt = homeUseCase.getJwt()
        if (jwt != null) {
            _jwt.postValue(jwt)
        }
    }


}