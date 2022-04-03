package com.poli.prevendasomie.signup.domain.model

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.login.domain.model.Token

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
