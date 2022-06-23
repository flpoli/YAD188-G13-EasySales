package com.poli.easysales.presentation.clientes.client_detail.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

@Composable
fun ClientOrders(

    orders: List<PedidoVendaProduto>
) {

    LazyColumn {

        item {

            orders.forEach {

                OrderCard(order = it)
            }
        }
    }
}
