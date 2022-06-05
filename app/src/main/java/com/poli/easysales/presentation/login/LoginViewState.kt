package com.poli.easysales.presentation.login

import com.poli.easysales.core.UiText
import com.poli.easysales.login.domain.model.Credentials

sealed class LoginViewState(
    open val credentials: Credentials,
    open val inputEnabled: Boolean = true
) {

    object Initial : LoginViewState(
        credentials = Credentials()
    )

    data class Active(
        override val credentials: Credentials,
        val emailInputErrorMessage: UiText? = null,
        val passwordInputErrorMessage: UiText? = null
    ) : LoginViewState(credentials = credentials)

    data class Submitting(
        override val credentials: Credentials
    ) : LoginViewState(
        credentials = credentials,
        inputEnabled = false

    )

    data class SubmissionError(
        override val credentials: Credentials,
        val errorMessage: UiText
    ) : LoginViewState(
        credentials = credentials,
    )

    object Completed : LoginViewState(
        credentials = Credentials(),
        inputEnabled = false
    )
}
