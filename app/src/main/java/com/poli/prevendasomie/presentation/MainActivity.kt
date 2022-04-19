package com.poli.prevendasomie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.poli.prevendasomie.navigation.SetupNavGraph
import com.poli.prevendasomie.ui.theme.PreVendasOmieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreVendasOmieTheme {

                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()

                var selectedItem by remember { mutableStateOf(0) }
                val items = listOf("Clientes", "Produtos", "Pedidos")

                SetupNavGraph(
                    navController = navController,
                    scaffoldState = scaffoldState
                )

                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}
