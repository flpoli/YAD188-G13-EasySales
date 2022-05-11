package com.poli.prevendasomie.presentation.pedidos

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.poli.prevendasomie.navigation.Screen

@Composable
fun OrdersFormScreen(
    navController: NavHostController,
    viewModel: OrdersFormViewModel = hiltViewModel()
) {

    AddClientBox(
        navController = navController,
        onClick = viewModel::onAddClientClicked
    )
}

@Composable
fun AddClientBox(
    navController: NavHostController,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth(.9f)
            .size(20.dp)
            .background(
                color = Color.Gray,
            )
            .border(
                width = 2.dp,
                color = Color.Black
            )
            .clickable {

                onClick()
                navController.navigate(Screen.ClientListScreen.route)
            }
    ) {

        Text(text = "Adicione o cliente")
    }
}
