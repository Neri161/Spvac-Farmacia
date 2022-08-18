package com.spvacfarmacia.Modelos

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("error") val error: String,
    @SerializedName("token") val token: String,
)
