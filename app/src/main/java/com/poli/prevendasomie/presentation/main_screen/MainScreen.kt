package com.poli.prevendasomie.presentation.main_screen

import android.text.TextUtils.indexOf
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.main_screen.components.GreetingSection


@Composable
fun MainScreen(
    navController: NavController,
    //viewModel: null = HiltViewModel()
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
                    ){
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
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
                        onClick = {
                            selectedItem = index
                            navController.navigate(Screen.ClientListScreen.route)

                        }
                    )
                }
            }

        }
    ){
        Column(){
            GreetingSection()
            FeatureSection(navController, Modifier.padding(top = 30.dp))
    }




}



}
