package com.poli.prevendasomie.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.core.UiText
import com.poli.prevendasomie.signup.domain.model.*
import com.poli.prevendasomie.signup.domain.usecase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {


    private val _viewState: MutableStateFlow<SignUpViewState> =
        MutableStateFlow(SignUpViewState.Initial)

    val viewState: StateFlow<SignUpViewState> = _viewState

    fun onSignUpClicked() {

        val currentUserData = _viewState.value.userData

        _viewState.value = SignUpViewState.Submitting(
            userData = currentUserData
        )

        viewModelScope.launch {

            val signUpResult = signUpUseCase(currentUserData)

            handleSignUpResult(signUpResult, currentUserData)

        }

    }

    fun onEmailChanged(email: String){

        val currentUserData = _viewState.value.userData

        _viewState.value = SignUpViewState.Active(
            userData = currentUserData.withUpdatedEmail(email),
        )

    }

    fun onPasswordChanged(password: String) {

        val currentUserData = _viewState.value.userData

        _viewState.value = SignUpViewState.Active(
            userData = currentUserData.withUpdatedPassword(password),
        )
    }

    fun onNameChanged(name: String) {
        val currentUserData = _viewState.value.userData

        _viewState.value = SignUpViewState.Active(
            userData = currentUserData.withUpdatedName(name),
        )
    }

    private fun handleSignUpResult(
        signUpResult: SignUpResult,
        currentUserData: UserData,
    ){

        _viewState.value = when(signUpResult) {

            is SignUpResult.Success -> {
                SignUpViewState.Completed
            }
            is SignUpResult.Failure -> {
                SignUpViewState.SubmissionError(
                    userData = currentUserData,
                    errorMessage = UiText.StringText("submission error")
                )
            }
        }

        //TODO: handle submission errors

    }


}

private fun UserData.withUpdatedPassword(password: String): UserData {
    return this.copy(password = Password(password))
}
private fun UserData.withUpdatedEmail(email: String): UserData {
    return this.copy(email = Email(email))
}
private fun UserData.withUpdatedName(name: String): UserData {
    return this.copy(name = Name(name))
}
