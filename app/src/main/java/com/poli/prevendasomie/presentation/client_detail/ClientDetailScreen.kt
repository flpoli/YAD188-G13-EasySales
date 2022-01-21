package com.poli.prevendasomie.presentation.client_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    ){

        state.client?.let { client ->

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ){


                item {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,

                    ) {

                        Text(
                            text = "${client.nomeFantasia}"
                        )
                        Text(
                            text = "${client.razaoSocial}"
                        )
                        Text(
                            text = "${client.nomeFantasia}"
                        )

                    }
                }

            }
        }
    }
}

//Row(
//modifier = Modifier
//.fillMaxSize(),
//
//verticalAlignment = Alignment.CenterVertically
//){
//
//    Column(){
//
//
//        Text("Razão Social: ${state.client?.razaoSocial}")
//        Text("Nome Fantasia: ${state.client?.nomeFantasia}")
//        Text("CPF / CNPJ: ${state.client?.cnpjCpf}")
//
//
//    }
//
//
//
//
//}