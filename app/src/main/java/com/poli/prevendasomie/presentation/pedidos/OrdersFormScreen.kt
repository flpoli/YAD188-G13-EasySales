package com.poli.prevendasomie.presentation.pedidos

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.navigation.Screen
import kotlinx.coroutines.InternalCoroutinesApi

@Composable
fun OrdersFormScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: OrdersFormViewModel = hiltViewModel()
) {


    LaunchedEffect(key1 = true){

        viewModel.uiEvent.collect {

                event ->
                    when(event){

                        is UiEvent.Navigate -> onNavigate(event)
                        else -> Unit

                    }
                }
    }


    AddClientBox(

        onClick = { onNavigate(UiEvent.Navigate(Screen.ClientSelectionScreen.route)) }
    )
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

        Spacer(modifier = Modifier.height(12.dp))

        Row(

            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(20.dp)


        ) {

            Text(text = "Novo produto")

        }
    }

}


@Preview
@Composable
fun PreviewClientSelectionBox() {

    //AddClientBox()

}