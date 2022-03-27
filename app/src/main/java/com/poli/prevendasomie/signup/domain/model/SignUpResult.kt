package com.poli.prevendasomie.signup.domain.model

sealed class SignUpResult {

    object Success : SignUpResult()

    sealed class Failure : SignUpResult() {

        object Unknown : Failure() // only this for now
    }
}
