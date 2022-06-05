package com.poli.easysales.login.domain.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: Token

)
