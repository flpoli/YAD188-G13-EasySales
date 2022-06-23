package com.poli.easysales.presentation.clientes.client_detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.poli.easysales.domain.model.pedidos.InfoCadastro
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

@Composable
fun OrderCard(
    order: PedidoVendaProduto
) {

    Box(
        modifier = Modifier
            .border(
                border = BorderStroke(2.dp, SolidColor(Black)),
                shape = RoundedCornerShape(12.dp)
            )
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        Row {

            Column {

                Text(text = order.cabecalho.numeroPedido)
                Text(text = order.totalPedido?.valorTotalPedido.toString())
            }

            if (order.cabecalho.etapa != null) {

                Text(text = order.cabecalho.etapa)
            }
        }
    }

    Spacer(Modifier.height(8.dp))
}

@Composable
fun FatStatusChip(
    info: InfoCadastro
) {
}

@Composable
@Preview(showBackground = true)
fun PreviewOrderCard() {
}
