package com.poli.prevendasomie.data.remote.responses

import com.poli.prevendasomie.domain.model.UserDataModel
import com.poli.prevendasomie.signup.domain.model.SignUpResponse

data class ResponseSignUpDto(

    val id: Int? = 0,
    val username: String? = "",
    val email: String? = "",
    val phoneNumber: String? = "",
    val status: String? = "",
    val createdAt: String? = "",
    val appKey: String = "",
    val appSecret: String = ""
)
fun ResponseSignUpDto.toUserDataModel(): UserDataModel {

    return UserDataModel(
        id = id,
        username = username,
        email = email,
        appKey = appKey,
        appSecret = appSecret
    )
}
fun ResponseSignUpDto.toSignupResponse(): SignUpResponse {

    return SignUpResponse(
        id = id,
        username = username,
        email = email,
        phoneNumber = phoneNumber,
        status = status,
        createdAt = createdAt,
        appKey = appKey,
        appSecret = appSecret
    )
}
