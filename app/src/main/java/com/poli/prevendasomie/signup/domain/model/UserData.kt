package com.poli.prevendasomie.signup.domain.model

@JvmInline
value class Email(val value: String)

@JvmInline
value class Password(val value: String)

@JvmInline
value class Name(val value: String)

data class UserData(

    val name: Name = Name(""),
    val email: Email = Email(""),
    val password: Password = Password(""),
)