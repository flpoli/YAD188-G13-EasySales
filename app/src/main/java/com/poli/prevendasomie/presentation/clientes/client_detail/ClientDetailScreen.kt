package com.poli.prevendasomie.presentation.clientes.client_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ClientDetailScreen(
    navController: NavController,
    viewModel: ClientDetailViewModel = hiltViewModel(),
    codigoClienteOmie: String
) {

//    val state by remember {
//
//        viewModel.state
//    }

//    val client = state.client

    // não.. mentira. Na verdade sim:
    viewModel.loadClientByCode(codigoClienteOmie)

    val state = viewModel.state.value


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        state.client?.let { client ->

            Column(
                modifier = Modifier.fillMaxSize(),
            ) {


                Text(
                    text = "Nome fantasia:",
                    style = MaterialTheme.typography.h2,

                    )
                Text(
                    text = client.nomeFantasia,
                    style = MaterialTheme.typography.body2,
                )

                Text(
                    text = "Razão social:",
                    style = MaterialTheme.typography.h2,
                )

                Text(
                    text = client.razaoSocial,
                    style = MaterialTheme.typography.body1,
                )

                Text(
                    text = "CPF/CNPJ:",
                    style = MaterialTheme.typography.h2,
                )

                Text(
                    text = client.cnpjCpf
                )
                Text(
                    text = "Endereço:",
                    style = MaterialTheme.typography.h2,
                )
                Text(
                    text = "${client.endereco}, ${client.enderecoNumero} "
                )

                Text(
                    text = "Contato:",
                    style = MaterialTheme.typography.h2,
                )
                Text(
                    text = "Telefone: (${client.telefone1Ddd})${client.telefone1Numero}"
                )
                Text(
                    text = "E-mail: ${client.email}"
                )

            }
        }

    }
}



@Composable
fun Contato(){

}