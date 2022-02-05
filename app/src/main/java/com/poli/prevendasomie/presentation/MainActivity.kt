package com.poli.prevendasomie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
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

                Surface(color = MaterialTheme.colors.background) {

                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "vendas") },
                                navigationIcon = {
                                    IconButton(onClick = { /* doSomething() */ }) {
                                        Icon(Icons.Filled.Menu, contentDescription = null)
                                    }
                                }
                            )
                        },
                        bottomBar = {

                            BottomNavigation {
                                items.forEachIndexed { index, item ->
                                    BottomNavigationItem(
                                        icon = {
                                            Icon(
                                                Icons.Filled.Favorite,
                                                contentDescription = null
                                            )
                                        },
                                        label = { Text(item) },
                                        selected = selectedItem == index,
                                        onClick = { selectedItem = index }
                                    )
                                }
                            }

                        }
                    ) {



                            navController = rememberNavController()

                            SetupNavGraph(navController = navController)


                        }

                    }

            }
        }
    }}

