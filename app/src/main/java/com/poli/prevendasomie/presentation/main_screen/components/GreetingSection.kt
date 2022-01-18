package com.poli.prevendasomie.presentation.main_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GreetingSection(
    name: String = "Poli"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bem vindo, $name",
                style = MaterialTheme.typography.h5
            )
            Text(
                text = "We wish you have a good day",
                style = MaterialTheme.typography.body1
            )
        }
    }
}