package com.example.loginapp.data.network.entities.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("error")
    val error: Boolean,
    @SerializedName("token")
    val token: String
)