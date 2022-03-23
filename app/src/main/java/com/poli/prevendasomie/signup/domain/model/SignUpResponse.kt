package com.poli.prevendasomie.signup.domain.model

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.login.domain.model.Token

data class SignUpResponse(
    @SerializedName("token")
    val token: Token // provisório.. ou não
)
