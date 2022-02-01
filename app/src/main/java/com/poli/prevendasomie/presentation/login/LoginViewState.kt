package com.poli.prevendasomie.presentation.login

import com.poli.prevendasomie.core.UIText
import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.Email

sealed class LoginViewState(
    open val credentials: Credentials,
    open val inputEnabled: Boolean = true
) {

    object Initial: LoginViewState(
        credentials = Credentials()
    )


    data class Active(
        override val credentials: Credentials,
        val emailInputErrorMessage: UIText? = null,
        val passwordInputErrorMessage: UIText? = null
    ): LoginViewState(credentials = credentials)

    data class Submitting(
        override val credentials: Credentials
    ): LoginViewState(
        credentials = credentials,
        inputEnabled = false

    )

    data class SubmissionError(
        override val credentials: Credentials,
        val errorMessage: UIText
    ):LoginViewState(
        credentials = credentials,
    )

    object Completed : LoginViewState(
        credentials = Credentials(),
        inputEnabled = false
    )
}