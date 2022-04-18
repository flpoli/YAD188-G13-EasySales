package com.poli.prevendasomie.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
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



    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {

        Column(
            Modifier
                .padding(bottom = 350.dp)
        ) {
            AnimationComponent(
                modifier = Modifier
            )

        }

        Column(
            Modifier
                .padding(top = 450.dp)
                .align(Alignment.BottomEnd)
        ){
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
