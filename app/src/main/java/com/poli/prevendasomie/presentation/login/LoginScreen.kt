package com.poli.prevendasomie.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.poli.prevendasomie.ui.theme.ButtonShape
import com.poli.prevendasomie.R


@Composable
fun LoginScreen(
    navController: NavHostController,
    viewState: LoginViewState,
    viewModel: LoginViewModel = hiltViewModel(),
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
    ) {


        OutlinedTextField(
            value = "email",
            placeholder = { Text(text = "user@email.com") },
            label = { Text(text = "email") },
            onValueChange = {/*TODO*/ },
        )

        OutlinedTextField(
            value = "password",
            placeholder = { Text(text = "password") },
            label = { Text(text = "password") },
            onValueChange = {/*TODO*/ }
        )

        LoginButton(
            onClick = onLoginClicked,
            enabled = viewState.inputsEnabled,
        )



        Text(text= "Registrar")
        Text(text= "Recuperar senha")

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

//@Preview
//@Composable
//fun PreviewLoginScreen(navController = NavController) {
//
//
//    LoginScreen(navController = navController)
//
//}