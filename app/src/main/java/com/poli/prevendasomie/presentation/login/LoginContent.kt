package com.poli.prevendasomie.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.poli.prevendasomie.R
import com.poli.prevendasomie.core.getString
import com.poli.prevendasomie.presentation.components.AppTextField
import com.poli.prevendasomie.presentation.components.PrimaryButton
import com.poli.prevendasomie.presentation.components.SignUpButton

@Composable
fun LoginContent(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LoginInputsColumn(
            viewState,
            onEmailChanged,
            onPasswordChanged,
            onLoginClicked,
            onSignUpClicked,
        )
    }
}

@Composable
private fun LoginButton(
    onClick: () -> Unit,
    enabled: Boolean,
) {
    PrimaryButton(
        text = stringResource(R.string.log_in),
        onClick = onClick,
        enabled = enabled,
    )
}

@Composable
private fun LoginInputsColumn(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        EmailInput(
            text = viewState.credentials.email.value,
            onTextChanged = onEmailChanged,
            errorMessage = (viewState as? LoginViewState.Active)
                ?.emailInputErrorMessage
                ?.getString(),
            enabled = viewState.inputEnabled
        )

        Spacer(modifier = Modifier.height(12.dp))

        PasswordInput(
            text = viewState.credentials.password.value,
            onTextChanged = onPasswordChanged,
            errorMessage = (viewState as? LoginViewState.Active)
                ?.passwordInputErrorMessage
                ?.getString(),
            enabled = viewState.inputEnabled

        )

        if (viewState is LoginViewState.SubmissionError) {

            Text(
                text = viewState.errorMessage.getString(),
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        LoginButton(
            onClick = onLoginClicked,
            enabled = viewState.inputEnabled
        )

        Spacer(modifier = Modifier.height(12.dp))

        SignUpButton(
            onClick = onSignUpClicked,
            enabled = viewState.inputEnabled
        )
    }
}

@Composable
private fun EmailInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean

) {

    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Email",
        enabled = enabled
    )
}

@Composable
private fun PasswordInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean
) {
    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Password",
        enabled = enabled
    )
}
