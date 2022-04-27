package com.poli.prevendasomie.presentation.clientes.client_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.poli.prevendasomie.R
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

@Composable
fun ClientRow(
    entries: ClientesCadastro,
    navController: NavController,
    onItemClick: () -> Unit
) {

    Column {
        Row(
            modifier = Modifier
                .clickable {
                    println("Cliquei no item da lista?")
                    onItemClick()
                }
        ) {
            ClientEntry(
                entry = entries, navController = navController,
                dataIcon = painterResource(
                    id = R.drawable.account_circle
                )
            )
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
