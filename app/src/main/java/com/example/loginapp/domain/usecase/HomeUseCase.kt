package com.example.loginapp.domain.usecase

import com.example.loginapp.domain.repository.HomeRepository

class HomeUseCase(private  val homeRepository: HomeRepository) {

     fun getJwt(): String? {
        val jwt = homeRepository.getJwt()
        if (jwt != null) {
            return jwt
        }
        return null
    }

}