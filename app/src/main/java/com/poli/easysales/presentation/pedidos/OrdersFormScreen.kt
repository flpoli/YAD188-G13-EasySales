package com.poli.easysales.presentation.pedidos

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.easysales.core.UiEvent
import com.poli.easysales.navigation.Screen

@Composable
fun OrdersFormScreen(
    navController: NavHostController,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: OrdersFormViewModel = hiltViewModel()
) {

    val key = viewModel.key

    val state by remember(key) { viewModel.state }

    // val test = produceState(initialValue = true) { value = viewModel.state }.value

    Log.d("STATE", "$state")
    Log.d("STATE - KEY", "$key")

    LaunchedEffect(key1 = true) {

        viewModel.uiEvent.collect {

                event ->
            when (event) {

                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }

    Column {

        ClientBox(

            state = state,
            onClick = { onNavigate(UiEvent.Navigate(Screen.ClientSelectionScreen.route)) }
        )
        Spacer(modifier = Modifier.height(12.dp))

        ProductBox(
            state = state,
            onClick = { onNavigate(UiEvent.Navigate(Screen.ProductSelectionScreen.route)) }
        )
    }
}

@Composable
fun ClientBox(
    state: OrderOverviewState,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {

                onClick()
            }
    ) {

        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxWidth()
                .padding(20.dp)

        ) {

            Text(text = "selecionar?   ")

            Text(text = "${state.cliente.nomeFantasia}")
        }
    }
}

@Composable
fun ProductBox(
    state: OrderOverviewState,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }
    ) {

        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxWidth()
                .padding(20.dp)

        ) {

            println(state.produtos)
            if (state.produtos.isEmpty()) {
                Text(text = "Selecionar produto")
            } else {

                Text(text = "${state.produtos}")
            }
        }
    }
}
