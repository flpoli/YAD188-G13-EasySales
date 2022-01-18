package com.poli.prevendasomie.presentation.client_detail

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.data.remote.responses.ClientList
import com.poli.prevendasomie.data.remote.responses.ClientesCadastro

@Composable
fun ClientDetailScreen(
    navController: NavController,
    viewModel: ClientDetailViewModel = hiltViewModel(),
    codigoClienteOmie: String
) {


    viewModel.loadClientByCode(codigoClienteOmie)

    val clientDetails = viewModel.clientDetails.value
    Row(){

        Text("Oi $codigoClienteOmie ?")
        Text("${clientDetails.nomeFantasia}")

    }




}

