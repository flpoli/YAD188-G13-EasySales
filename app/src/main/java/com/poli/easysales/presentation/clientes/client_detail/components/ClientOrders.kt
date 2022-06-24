package com.poli.easysales.presentation.clientes.client_detail.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

@Composable
fun ClientOrders(

    orders: List<PedidoVendaProduto>
) {

    LazyColumn(
        contentPadding = PaddingValues(top = 16.dp, bottom = 36.dp)
    ) {

        item {

            orders.forEach {

                OrderCard(order = it)
            }
        }
    }
}
