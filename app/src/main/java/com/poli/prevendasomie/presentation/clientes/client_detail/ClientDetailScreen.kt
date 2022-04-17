package com.poli.prevendasomie.presentation.clientes.client_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.presentation.clientes.client_detail.components.InfoBox
import com.poli.prevendasomie.ui.theme.BlueViolet3

@Composable
fun ClientDetailScreen(
    navController: NavController,
    viewModel: ClientDetailViewModel = hiltViewModel(),
    codigoClienteOmie: String
) {

    viewModel.loadClientByCode(codigoClienteOmie)

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .background(color = BlueViolet3)
            .fillMaxSize()
    ) {

        state.client?.let { client ->

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
                    info = client.email ?: "sem username",
                    subtitle = "Telefone: (${client.telefone1Ddd})${client.telefone1Numero}"
                )
                InfoBox(
                    title = "Endereço",
                    info = "${ client.endereco }, ${ client.enderecoNumero }, ${client.bairro}",
                    subtitle = "CEP: ${client.cep}"
                )
            }
        }
    }
}
