package com.poli.prevendasomie.presentation.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.poli.prevendasomie.presentation.Screen
import com.poli.prevendasomie.presentation.main_screen.components.FeatureItem

@Composable
fun FeatureSection(navController: NavController, modifier: Modifier ) {

    Spacer(modifier = Modifier.padding(top = 80.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End

        ){

        Column{
            Text(
                text = "Features",
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(15.dp)

            )

            Button(
                onClick = {navController.navigate(Screen.ClientListScreen.route)},
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ){
                Text("Clientes")
            }
            Button(
                onClick = {navController.navigate(Screen.ClientListScreen.route)},
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ){
                Text("Produtos")
            }
            Button(
                onClick = {navController.navigate(Screen.ClientListScreen.route)},
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ){
                Text("Pedidos")
            }
        }



    }
}