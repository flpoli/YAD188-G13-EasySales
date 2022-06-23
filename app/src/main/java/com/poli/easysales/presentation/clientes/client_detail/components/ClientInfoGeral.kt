package com.poli.easysales.presentation.clientes.client_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.poli.easysales.domain.model.clientes.Caracteristica
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

@Composable
fun ClientInfoGeral(
    client: ClientesCadastro = ClientesCadastro(),
    orders: List<PedidoVendaProduto> = emptyList(),
    caracteristicas: List<Caracteristica> = emptyList(),
    modifier: Modifier = Modifier

) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        InfoBox(
            title = "Contato",
            info = "e-mail: ${client.email}",
            subtitle = "Telefone: (${client.telefone1Ddd})${client.telefone1Numero}"
        )
        InfoBox(
            title = "Endereço",
            info = "${client.endereco}, ${client.enderecoNumero}, ${client.bairro}",
            subtitle = "CEP: ${client.cep}"
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {

            item {
                client.tags?.forEach {
                    ClientTagChip(tag = it)
                }
            }
        }
    }

}
