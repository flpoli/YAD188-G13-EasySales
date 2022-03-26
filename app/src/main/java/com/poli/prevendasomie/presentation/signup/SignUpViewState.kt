package com.poli.prevendasomie.presentation.signup

import com.poli.prevendasomie.core.UiText
import com.poli.prevendasomie.signup.domain.model.UserData

sealed class SignUpViewState(

    open val userData: UserData,
    open val inputEnabled: Boolean = true

) {


    object Initial: SignUpViewState(
        userData = UserData(),
    )

    data class Active(
        override val userData: UserData,
        val emailInputErrorMessage: UiText? = null,
        val passwordInputErrorMessage: UiText? = null,
        val nameInputErrorMessage: UiText? = null,
    ): SignUpViewState(userData = userData)

    data class Submitting(
        override val userData: UserData,
        ): SignUpViewState(
            userData = userData,
            inputEnabled = false
        )
    object Completed: SignUpViewState (
        userData = UserData(),
        inputEnabled = false
    )

    data class SubmissionError(
        override val userData: UserData,
        val errorMessage: UiText
    ): SignUpViewState(
        userData = UserData(),
    )
}