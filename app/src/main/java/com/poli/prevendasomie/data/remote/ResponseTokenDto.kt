package com.poli.prevendasomie.data.remote

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.login.domain.model.AuthToken
import com.poli.prevendasomie.login.domain.model.Token
import com.poli.prevendasomie.login.domain.model.TokenExpiry
import com.poli.prevendasomie.login.domain.model.TokenType

data class ResponseTokenDto(
    @SerializedName("access_token")
    val authToken: String,
    @SerializedName("token_expiry")
    val tokenExpiry: String,
    @SerializedName("token_type")
    val tokenType: String
)

fun ResponseTokenDto.toToken(): Token {

    return Token(
        authToken = AuthToken(authToken),
        tokenExpiry = TokenExpiry(tokenExpiry),
        tokenType = TokenType(tokenType)
    )
}
