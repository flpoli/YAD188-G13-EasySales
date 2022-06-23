package com.poli.easysales.presentation.clientes.client_detail.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(
    val icon: Int,
    val title: String,
    val screen: ComposableFun
) {
    object ClientInfoGeral : TabItem(0, "Informações", { })
    object ClientOrders : TabItem(0, "pedidos", { Text(text = "PEDIDOS") })
    object AditionalInfo : TabItem(0, "aditional", { Text(text = "ADITIONAL INFO") })
}
