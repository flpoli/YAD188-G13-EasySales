package com.poli.prevendasomie.presentation.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController


@Composable
fun LoginScreen(
    navController: NavHostController
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

        Button(

            modifier = Modifier.padding(20.dp),

            onClick = { /*TODO*/
//            if (email.isBlank() == false && password.isBlank() == false) {
//                onLoginClick(email)
//                focusManager.clearFocus()
//            } else {
//                Toast.makeText(
//                    context,
//                    "Please enter email and password",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
            }
        ) {
            Text("Login")
        }

        Text(text= "Registrar")
        Text(text= "Recuperar senha")

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