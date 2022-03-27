package com.poli.prevendasomie.login.domain.model

import com.google.gson.annotations.SerializedName

@JvmInline
value class AuthToken(val value: String)

@JvmInline
value class RefreshToken(val value: String)

data class Token(
    @SerializedName("authToken")
    val authToken: AuthToken,
    @SerializedName("refreshToken")
    val refreshToken: RefreshToken
)
