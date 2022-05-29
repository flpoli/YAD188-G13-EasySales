package com.poli.prevendasomie.presentation.pedidos.orderdetail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun OrderDetailScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: OrderDetailViewModel = hiltViewModel()
) {

    val selectedOrder by viewModel.selectedOrder.collectAsState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.Gray
            )
            .border(
                border = BorderStroke(2.dp, color = Color.Black)
            )

    ) {

        Text(text = "Produtos:")

        selectedOrder?.det?.forEach {

                produto ->

            produto.produto?.let {

                Row() {

                    Text(text = it.quantidade.toString())
                    Text(text = it.descricao.toString())
                }
//                Row(){
//
//                }
            }
        }
    }
}
