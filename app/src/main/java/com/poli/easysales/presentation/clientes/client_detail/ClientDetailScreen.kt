package com.poli.easysales.presentation.clientes.client_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.easysales.presentation.clientes.client_detail.components.ClientTagChip
import com.poli.easysales.presentation.clientes.client_detail.components.InfoBox
import com.poli.easysales.ui.theme.BlueViolet3

@Composable
fun ClientDetailScreen(
    navController: NavHostController,
    viewModel: ClientDetailViewModel = hiltViewModel(),

) {

    val orders by viewModel.orders.collectAsState()
    val selectedClient by viewModel.selectedClient.collectAsState()

    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.surface)
            .fillMaxSize()
    ) {

        selectedClient?.let { client ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
            ) {
                InfoBox(
                    title = "Nome",
                    info = client.nomeFantasia ?: "Não informado",
                    subtitle = client.cnpjCpf ?: "Não informado"
                )
                InfoBox(
                    title = "Contato",
                    info = "e-mail: ${client.email}" ?: "não informado",
                    subtitle = "Telefone: (${client.telefone1Ddd})${client.telefone1Numero}"
                )
                InfoBox(
                    title = "Endereço",
                    info = "${ client.endereco }, ${ client.enderecoNumero }, ${client.bairro}",
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

                Text(text = "Pedidos deste cliente:")
                orders?.forEach {
                    Text(text = it.cabecalho?.numeroPedido!!)
                }


            }
        }
    }
}
