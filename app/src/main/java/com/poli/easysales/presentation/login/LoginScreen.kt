package com.poli.easysales.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.components.AnimationComponent
import com.poli.prevendasomie.R

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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {

        Column(
            Modifier
                .padding(bottom = 350.dp)
        ) {
            AnimationComponent(animResource = R.raw.loginamination)
        }

        Column(
            Modifier
                .padding(top = 450.dp)
                .align(Alignment.BottomEnd)
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
}
