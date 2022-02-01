package com.poli.prevendasomie.login.domain.model

sealed class LoginResult {

    object Success: LoginResult()

    sealed class Failure: LoginResult(){

        object InvalidCredentials : Failure()
        object Unknown: Failure()

        data class EmptyCredentials(

            val emptyEmail: Boolean,
            val emptyPassword: Boolean
        ) : Failure()

    }

}
