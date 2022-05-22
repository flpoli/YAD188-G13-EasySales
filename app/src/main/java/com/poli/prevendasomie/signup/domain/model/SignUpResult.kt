package com.poli.prevendasomie.signup.domain.model

sealed class SignUpResult {

    object Success : SignUpResult()

    sealed class Failure : SignUpResult() {

        object UserNameNotAvailable : Failure()
        object ConfirmPasswordMatch : Failure()
        object Unknown : Failure()
    }
}
