package com.poli.easysales.login.domain.model

@JvmInline
value class AuthToken(val value: String)
@JvmInline
value class RefreshToken(val value: String)
@JvmInline
value class TokenExpiry(val value: String)
@JvmInline
value class TokenType(val value: String)

data class Token(
    val authToken: AuthToken,
)
