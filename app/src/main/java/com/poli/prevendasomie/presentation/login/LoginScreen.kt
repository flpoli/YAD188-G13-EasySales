package com.poli.prevendasomie.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.prevendasomie.navigation.Screen

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel(),
) {

    val viewState = viewModel.viewState.collectAsState()
    val context = LocalContext.current

    DisposableEffect(viewState.value) {

        if (viewState.value is LoginViewState.Completed) {

            navController.navigate(Screen.MainScreen.route)
        }

        onDispose { }
    }

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginContent(
            viewState = viewState.value,
            onEmailChanged = viewModel::emailChanged,
            onPasswordChanged = viewModel::passwordChanged,
            onLoginClicked = viewModel::loginButtonClicked,
            onSignUpClicked = {
                navController.navigate(Screen.SignUpScreen.route)
            }
        )
    }
}
