package com.poli.prevendasomie.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.core.UiText
import com.poli.prevendasomie.signup.domain.model.Email
import com.poli.prevendasomie.signup.domain.model.Password
import com.poli.prevendasomie.signup.domain.model.SignUpResult
import com.poli.prevendasomie.signup.domain.model.UserData
import com.poli.prevendasomie.signup.domain.model.Username
import com.poli.prevendasomie.signup.domain.usecase.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    private val _viewState: MutableStateFlow<SignUpViewState> =
        MutableStateFlow(SignUpViewState.Initial)

    val viewState: StateFlow<SignUpViewState> = _viewState

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

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

    fun onEmailChanged(email: String) {

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

    fun onPasswordConfirmationChanged(password: String) {

        val currentUserData = _viewState.value.userData

        _viewState.value = SignUpViewState.Active(
            userData = currentUserData.withUpdatedConfirmPassword(password)
        )
    }

    fun onNameChanged(name: String) {
        val currentUserData = _viewState.value.userData

        _viewState.value = SignUpViewState.Active(
            userData = currentUserData.withUpdatedName(name),
        )
    }

    private suspend fun handleSignUpResult(
        signUpResult: SignUpResult,
        currentUserData: UserData,
    ) {

        _viewState.value = when (signUpResult) {

            is SignUpResult.Success -> {
                SignUpViewState.Completed
            }
            is SignUpResult.Failure.ConfirmPasswordMatch -> {

                _uiEvent.send(UiEvent.ShowSnackbar(UiText.StringText("Senhas não conferem")))

                SignUpViewState.SubmissionError(
                    userData = currentUserData,
                    errorMessage = UiText.StringText("Senhas não conferem")
                )
            }

            is SignUpResult.Failure.UserNameNotAvailable -> {

                _uiEvent.send(UiEvent.ShowSnackbar(UiText.StringText("Este username já está sendo utilizado")))

                SignUpViewState.SubmissionError(
                    userData = currentUserData,
                    errorMessage = UiText.StringText("submission error")
                )
            }

            is SignUpResult.Failure.Unknown -> {
                SignUpViewState.SubmissionError(
                    userData = currentUserData,
                    errorMessage = UiText.StringText("submission error")
                )
            }
        }
    }
}

private fun UserData.withUpdatedPassword(password: String): UserData {
    return this.copy(password = Password(password))
}

private fun UserData.withUpdatedConfirmPassword(password: String): UserData {
    return this.copy(passwordConfirm = Password(password))
}

private fun UserData.withUpdatedEmail(email: String): UserData {
    return this.copy(email = Email(email))
}
private fun UserData.withUpdatedName(name: String): UserData {
    return this.copy(username = Username(name))
}
