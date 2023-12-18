package com.example.loginapp.data.network.entities.response

import com.google.gson.annotations.SerializedName

data class TokenResponse(
@SerializedName("message")
val message: String,
@SerializedName("error")
val error: Boolean,
)
