package com.example.loginapp.data.model
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("error")
    val error: Boolean
)