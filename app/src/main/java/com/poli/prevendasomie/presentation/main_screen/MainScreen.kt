package com.poli.prevendasomie.presentation.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.poli.prevendasomie.domain.model.UserDataModel
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.main_screen.components.BottomNavigationBar
import com.poli.prevendasomie.presentation.main_screen.components.GreetingSection

@Composable
fun MainScreen(
    navController: NavHostController,
    // viewModel: null = HiltViewModel()
) {

    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Clientes", "Produtos", "Pedidos")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = items[selectedItem]) },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )
        },
        bottomBar = {

            BottomNavigationBar(navController = navController)
        }
    ) {
        Column() {
            GreetingSection(name = UserDataModel().username ?: "XYZZZZ")
        }
    }
}
