package com.poli.prevendasomie.presentation.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.core.getString
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.components.AppTextField
import com.poli.prevendasomie.presentation.components.SignUpButton
import com.poli.prevendasomie.ui.theme.LocalSpacing
import kotlinx.coroutines.flow.collect

@Composable
fun SignupScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    viewModel: SignUpViewModel = hiltViewModel()
) {

    val viewState = viewModel.viewState.collectAsState()
    val context = LocalContext.current
    val spacing = LocalSpacing.current

    DisposableEffect(viewState.value) {

        if (viewState.value is SignUpViewState.Completed) {

            navController.navigate(Screen.LoginScreen.route)
        }

        onDispose { }
    }

    LaunchedEffect(key1 = true) {

        viewModel.uiEvent.collect {
                event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.getString(context)
                    )
                }
            }
        }
    }

    Column(
        modifier = Modifier.padding(top = 20.dp)
    ) {

        SignUpContent(
            viewState = viewState.value,
            onNameChanged = viewModel::onNameChanged,
            onEmailChanged = viewModel::onEmailChanged,
            onPasswordChanged = viewModel::onPasswordChanged,
            onPasswordConfirmationChanged = viewModel::onPasswordConfirmationChanged,
            onSignUpClicked = viewModel::onSignUpClicked,
        )
    }
}

@Composable
fun SignUpContent(
    viewState: SignUpViewState,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordConfirmationChanged: (String) -> Unit,
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
            onPasswordConfirmationChanged,
            onSignUpClicked,

        )
    }
}

@Composable
fun SignUpInputColumn(
    viewState: SignUpViewState,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordConfirmationChanged: (String) -> Unit,
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
            enabled = viewState.inputEnabled,
        )

        Spacer(modifier = Modifier.height(12.dp))

        PasswordValidationInputField(
            text = viewState.userData.passwordConfirm.value,
            onTextChanged = onPasswordConfirmationChanged,
            errorMessage = null,
            enabled = viewState.inputEnabled,
        )

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
        enabled = enabled,
        trailingIcon = {}
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
        labelText = "Username",
        enabled = enabled,
        trailingIcon = {}
    )
}

@Composable
fun PasswordInputField(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean,
) {
    val showPassword = remember { mutableStateOf(false) }
    val icon = if (showPassword.value) {
        Icons.Filled.Visibility
    } else {
        Icons.Filled.VisibilityOff
    }

    val visualTransformation = if(showPassword.value){VisualTransformation.None} else {
        PasswordVisualTransformation()}
    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Password",
        visualTransformation = visualTransformation,

        enabled = enabled,
        trailingIcon = {

            IconButton(

                modifier = Modifier,
                onClick = { showPassword.value = !showPassword.value },

            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Visibility",
                    modifier = Modifier.clickable { showPassword.value = !showPassword.value }

                )
            }
        }
    )
}

@Composable
fun PasswordValidationInputField(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean
) {
    val showPassword = remember { mutableStateOf(false) }
    val icon = if (showPassword.value) {
        Icons.Filled.Visibility
    } else {
        Icons.Filled.VisibilityOff
    }

    val visualTransformation = if(showPassword.value){VisualTransformation.None} else {
        PasswordVisualTransformation()}

    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Repeat password",
        enabled = enabled,
        visualTransformation = visualTransformation,
        trailingIcon = {

            IconButton(

                modifier = Modifier,
                onClick = { showPassword.value = !showPassword.value },

                ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Visibility",
                    modifier = Modifier.clickable { showPassword.value = !showPassword.value }

                )
            }
        }
    )
}
