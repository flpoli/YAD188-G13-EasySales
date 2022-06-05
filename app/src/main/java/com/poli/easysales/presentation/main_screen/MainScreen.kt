package com.poli.easysales.presentation.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.poli.easysales.domain.model.UserDataModel
import com.poli.easysales.presentation.main_screen.components.GreetingSection

@Composable
fun MainScreen(
    navController: NavHostController,
    // viewModel: null = HiltViewModel()
) {

    val selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Clientes", "Produtos", "Pedidos")

    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(text = items[selectedItem]) },
//                navigationIcon = {
//                    IconButton(onClick = { /* doSomething() */ }) {
//                        Icon(Icons.Filled.Menu, contentDescription = null)
//                    }
//                },
//                actions = {
//                    IconButton(
//                        onClick = {}
//                    ) {
//                        Icon(
//                            imageVector = Icons.Filled.Search,
//                            contentDescription = "Search"
//                        )
//                    }
//                }
//            )
//        },
        bottomBar = {

            // BottomNavigationBar(navController = navController)
        }
    ) {
        Column() {
            GreetingSection(name = UserDataModel().username ?: "XYZZZZ")
        }
    }
}
