package com.poli.prevendasomie.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.poli.prevendasomie.core.getString
import com.poli.prevendasomie.ui.theme.TextFieldShape


@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel(),
) {

    val viewState = viewModel.viewState.collectAsState()

    val context = LocalContext.current

    LoginContent(
        viewState = viewState.value,
        onEmailChanged = viewModel::emailChanged,
        onPasswordChanged = viewModel::passwordChanged,
        onLoginClicked = viewModel::loginButtonClicked,
        onSignUpClicked = {
            Toast.makeText(context, "TODO", Toast.LENGTH_LONG).show()
        }


    )

}






