package com.poli.prevendasomie.presentation.clientes.client_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.R
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

                Text(
                    text = "Nome fantasia:",
                    style = MaterialTheme.typography.h2,
                    )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = client.nomeFantasia,
                    style = MaterialTheme.typography.body2,
                )

                Text(
                    text = "Razão social:",
                    style = MaterialTheme.typography.h2,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = client.razaoSocial,
                    style = MaterialTheme.typography.body1,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "CPF/CNPJ:",
                    style = MaterialTheme.typography.h2,
                )
                Text(
                    text = client.cnpjCpf
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Endereço:",
                    style = MaterialTheme.typography.h2,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "${client.endereco}, ${client.enderecoNumero} "
                )

                Text(
                    text = stringResource(R.string.details_screen_contato),
                    style = MaterialTheme.typography.h2,
                )
                Spacer(modifier = Modifier.height(20.dp))
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

