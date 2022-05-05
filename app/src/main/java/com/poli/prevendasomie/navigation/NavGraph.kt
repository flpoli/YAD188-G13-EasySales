package com.poli.prevendasomie.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.poli.prevendasomie.presentation.clientes.client_detail.ClientDetailScreen
import com.poli.prevendasomie.presentation.clientes.client_list.ClientListScreen
import com.poli.prevendasomie.presentation.clientes.cliente_form.ClientFormScreen
import com.poli.prevendasomie.presentation.login.LoginScreen
import com.poli.prevendasomie.presentation.main_screen.MainScreen
import com.poli.prevendasomie.presentation.pedidos.OrdersListScreen
import com.poli.prevendasomie.presentation.produtos.productslist.ProductListScreen
import com.poli.prevendasomie.presentation.signup.SignupScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    scaffoldState: ScaffoldState
) {

    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {

        composable("login_screen") {
            LoginScreen(navController = navController)
        }
        composable("signup_screen") {
            SignupScreen(navController = navController)
        }
        composable("main_screen") {
            MainScreen(navController = navController)
        }
        composable("client_list_screen") {
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

            ClientDetailScreen(
                navController = navController,

            )
        }
        composable("product_list_screen") {
            ProductListScreen(navController = navController)
        }
        composable("client_form_screen") {
            ClientFormScreen(
                navController = navController,
                scaffoldState = scaffoldState
            )
        }
        composable("order_list_screen") {
            OrdersListScreen(navController = navController)
        }
    }
}
