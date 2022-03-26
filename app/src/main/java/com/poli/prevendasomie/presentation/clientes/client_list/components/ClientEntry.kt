package com.poli.prevendasomie.presentation.clientes.client_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.data.remote.responses.ClientesCadastro
import com.poli.prevendasomie.presentation.clientes.client_list.ClientListViewModel

@Composable
fun ClientEntry(

    entry: ClientesCadastro,
    dataIcon: Painter,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ClientListViewModel = hiltViewModel()
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)


        ) {
        Icon(
            painter = dataIcon,
            contentDescription = null,
            modifier = Modifier.padding(10.dp),
        )
        Text(
            text = "${entry.nomeFantasia}\n${entry.cnpjCpf}\n${entry.telefone1Numero}",
            modifier = Modifier.fillMaxWidth()
        )
    }
}



