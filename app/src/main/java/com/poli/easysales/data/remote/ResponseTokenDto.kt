package com.poli.easysales.data.remote

import com.google.gson.annotations.SerializedName
import com.poli.easysales.login.domain.model.AuthToken
import com.poli.easysales.login.domain.model.Token

data class ResponseTokenDto(
    @SerializedName("access_token")
    val authToken: String? = "",
    @SerializedName("token_expiry")
    val tokenExpiry: String? = "",
    @SerializedName("token_type")
    val tokenType: String? = ""
)

fun ResponseTokenDto.toToken(): Token {

    return Token(
        authToken = AuthToken(authToken!!),

    )
}
