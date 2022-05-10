package com.poli.prevendasomie.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.poli.prevendasomie.presentation.clientes.client_detail.ClientDetailScreen
import com.poli.prevendasomie.presentation.clientes.client_list.ClientListScreen
import com.poli.prevendasomie.presentation.clientes.cliente_form.ClientFormScreen
import com.poli.prevendasomie.presentation.login.LoginScreen
import com.poli.prevendasomie.presentation.main_screen.MainScreen
import com.poli.prevendasomie.presentation.main_screen.components.BottomNavigationBar
import com.poli.prevendasomie.presentation.main_screen.components.FabButton
import com.poli.prevendasomie.presentation.pedidos.OrdersFormScreen
import com.poli.prevendasomie.presentation.pedidos.OrdersListScreen
import com.poli.prevendasomie.presentation.produtos.productslist.ProductListScreen
import com.poli.prevendasomie.presentation.signup.SignupScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    scaffoldState: ScaffoldState
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val selectedItem by remember { mutableStateOf(0) }
    val items =
        listOf(
            Screen.LoginScreen.route,
            Screen.MainScreen.route,
            "Clientes",
            "Produtos", "Pedidos"
        )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {

            if (
                navBackStackEntry?.destination?.route != Screen.LoginScreen.route &&
                navBackStackEntry?.destination?.route != Screen.SignUpScreen.route
            ) {
                TopAppBar(
                    title = { Text(text = items[selectedItem]) },
                    navigationIcon = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                    }
                )
            }
        },

        bottomBar = {
            if (
                navBackStackEntry?.destination?.route != Screen.LoginScreen.route &&
                navBackStackEntry?.destination?.route != Screen.SignUpScreen.route
            ) {
                BottomNavigationBar(navController)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        floatingActionButton = {

            if (
                navBackStackEntry?.destination?.route != Screen.LoginScreen.route &&
                navBackStackEntry?.destination?.route != Screen.SignUpScreen.route
            ) {

                FabButton(navController = navController)
            }
        }

    ) {

        NavHost(
            navController = navController,
            startDestination = Screen.LoginScreen.route
        ) {

            composable(Screen.LoginScreen.route) {
                LoginScreen(navController = navController)
            }
            composable(Screen.SignUpScreen.route) {
                SignupScreen(navController = navController)
            }
            composable(Screen.MainScreen.route) {
                MainScreen(navController = navController)
            }
            composable(Screen.ClientListScreen.route) {
                ClientListScreen(navController = navController)
            }
            composable(
                route = Screen.ClientDetailScreen.route,
                arguments = listOf(
                    navArgument("clientId") {
                        type = NavType.IntType
                    }
                )
            ) {

                ClientDetailScreen(navController = navController)
            }
            composable(Screen.ProductListScreen.route) {
                ProductListScreen(navController = navController)
            }
            composable(Screen.ClientFormScreen.route) {
                ClientFormScreen(
                    navController = navController,
                    scaffoldState = scaffoldState
                )
            }
            composable(Screen.OrdersListScreen.route) {
                OrdersListScreen(navController = navController)
            }
            composable(Screen.OrderFormScreen.route) {
                OrdersFormScreen(navController = navController)
            }
        }
    }
}
