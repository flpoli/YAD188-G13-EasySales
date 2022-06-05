package com.poli.easysales.signup.domain.model

@JvmInline
value class Email(val value: String)

@JvmInline
value class Password(val value: String)

@JvmInline
value class Username(val value: String)

data class UserData(

    val username: Username = Username(""),
    val email: Email = Email(""),
    val password: Password = Password(""),
    val passwordConfirm: Password = Password(""),
    val appKey: String = "",
    val appSecret: String = "",
    val token: String = ""

)