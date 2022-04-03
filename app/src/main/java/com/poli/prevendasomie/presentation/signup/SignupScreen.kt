package com.poli.prevendasomie.presentation.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.components.AppTextField
import com.poli.prevendasomie.presentation.components.SignUpButton

@Composable
fun SignupScreen(
    navController: NavHostController,
    viewModel: SignUpViewModel = hiltViewModel()
) {

    val viewState = viewModel.viewState.collectAsState()
    val context = LocalContext.current

    DisposableEffect(viewState.value) {

        if (viewState.value is SignUpViewState.Completed) {

            navController.navigate(Screen.LoginScreen.route)
        }

        onDispose { }
    }

    SignUpContent(
        viewState = viewState.value,
        onNameChanged = viewModel::onNameChanged,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onSignUpClicked = viewModel::onSignUpClicked,
    )
}

@Composable
fun SignUpContent(
    viewState: SignUpViewState,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSignUpClicked: () -> Unit,

) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        SignUpInputColumn(
            viewState,
            onNameChanged,
            onEmailChanged,
            onPasswordChanged,
            onSignUpClicked
        )
    }
}

@Composable
fun SignUpInputColumn(
    viewState: SignUpViewState,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSignUpClicked: () -> Unit,

) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        NameInputField(
            text = viewState.userData.username.value,
            onTextChanged = onNameChanged,
            errorMessage = null,
            enabled = viewState.inputEnabled
        )

        Spacer(modifier = Modifier.height(12.dp))

        EmailInputField(
            text = viewState.userData.email.value,
            onTextChanged = onEmailChanged,
            errorMessage = null,
            enabled = viewState.inputEnabled
        )
        Spacer(modifier = Modifier.height(12.dp))

        PasswordInputField(
            text = viewState.userData.password.value,
            onTextChanged = onPasswordChanged,
            errorMessage = null,
            enabled = viewState.inputEnabled
        )

        Spacer(modifier = Modifier.height(12.dp))

//        PasswordValidationInputField(
//            text = "",
//            onTextChanged = {},
//            errorMessage = null,
//            enabled = viewState.inputEnabled,
//        )

        Spacer(modifier = Modifier.height(12.dp))

        SignUpButton(
            onClick = onSignUpClicked,
            enabled = viewState.inputEnabled
        )
    }
}

@Composable
fun NameInputField(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean
) {

    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Nome",
        enabled = enabled
    )
}

@Composable()
fun EmailInputField(
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
fun PasswordInputField(
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

@Composable
fun PasswordValidationInputField(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean
) {

    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Repeat password",
        enabled = enabled
    )
}
