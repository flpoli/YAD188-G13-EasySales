package com.poli.prevendasomie.presentation.client_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.data.remote.responses.ClientesCadastro

@Composable
fun ClientDetailScreen(
    navController: NavController,
    viewModel: ClientDetailViewModel = hiltViewModel()
) {
    Text("ola mundo????")
    //Text(text = "${ClientesCadastro}")
}