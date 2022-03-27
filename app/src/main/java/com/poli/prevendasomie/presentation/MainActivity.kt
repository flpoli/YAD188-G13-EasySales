package com.poli.prevendasomie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.poli.prevendasomie.navigation.SetupNavGraph
import com.poli.prevendasomie.ui.theme.PreVendasOmieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreVendasOmieTheme {

                var selectedItem by remember { mutableStateOf(0) }
                val items = listOf("Clientes", "Produtos", "Pedidos")

                navController = rememberNavController()
                SetupNavGraph(navController = navController)
                Surface(color = MaterialTheme.colors.background) {
                }
            }
        }
    }
}
