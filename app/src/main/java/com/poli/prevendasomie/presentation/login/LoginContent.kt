package com.poli.prevendasomie.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.poli.prevendasomie.R
import com.poli.prevendasomie.core.getString
import com.poli.prevendasomie.ui.theme.ButtonShape
import com.poli.prevendasomie.ui.theme.TextFieldShape



@Composable
fun LoginContent(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit
){
    Box(
        modifier = Modifier
        .fillMaxSize()
    ){
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
private fun SignUpButton(
    onClick: () -> Unit,
    enabled: Boolean,
) {
    PrimaryButton(
        text = stringResource(R.string.sign_up),
        onClick = onClick,
        enabled = enabled,
    )
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
){
    Button(
        onClick = onClick,
        shape = ButtonShape,
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth(),
        enabled = enabled
    ){
        Text(
            text = text.toUpperCase(Locale.current),
        )
    }

}

@Composable
private fun LoginInputsColumn(
    viewState: LoginViewState,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
    ){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

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

        if (viewState is LoginViewState.SubmissionError){

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

){

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
){
    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Password",
        enabled = enabled
    )
}


@Composable
fun AppTextField(

    text: String,
    onTextChanged: (String) -> Unit,
    labelText: String?,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    placeholderText: String? = null,
){

    val labelComposable: (@Composable () -> Unit)? = labelText?.let {

        @Composable {
            Text(
                text = labelText,
            )
        }

    }

    val placeholderComposable: (@Composable () -> Unit)? = labelText?.let {

        @Composable {
            Text(
                text = labelText,
            )
        }

    }


    Column {

        OutlinedTextField(

            value = text,
            onValueChange = onTextChanged,
            label = labelComposable,
            shape = TextFieldShape,
            modifier = Modifier
                .heightIn(48.dp)
                .fillMaxWidth(),
            isError = (errorMessage != null),
            enabled = enabled,
            placeholder = placeholderComposable,
        )

        if(errorMessage != null){
            Text(
                text = errorMessage,
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        start = 16.dp
                    )
            )
        }

    }
}



