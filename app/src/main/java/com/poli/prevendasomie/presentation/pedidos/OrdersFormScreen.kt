package com.poli.prevendasomie.presentation.pedidos

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.pedidos.clientselection.ClientSelectionViewModel
import com.poli.prevendasomie.presentation.pedidos.clientselection.SelectionEvent

@Composable
fun OrdersFormScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: OrdersFormViewModel = hiltViewModel()
) {

    val state = viewModel
    println("ORDER SCREEN EVENT: $state")
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

        AddClientBox(

            onClick = {onNavigate(UiEvent.Navigate(Screen.ClientSelectionScreen.route))}
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Cliente Selecionado: ")

    }
}

@Composable
fun AddClientBox(

    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(20.dp)
                .clickable {
                    onClick()
                }

        ) {

            Text(text = "Selecionar cliente")
        }
    }
}
