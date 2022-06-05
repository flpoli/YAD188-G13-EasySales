package com.poli.easysales.signup.domain.model

data class SignUpResponse(

    val id: Int? = 0,
    val username: String? = "",
    val email: String? = "",
    val phoneNumber: String? = "",
    val status: String? = "",
    val createdAt: String? = "",
    val appKey: String? = "",
    val appSecret: String = ""
)
