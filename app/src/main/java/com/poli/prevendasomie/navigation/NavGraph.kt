package com.poli.prevendasomie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.poli.prevendasomie.presentation.clientes.client_detail.ClientDetailScreen
import com.poli.prevendasomie.presentation.clientes.client_list.ClientListScreen
import com.poli.prevendasomie.presentation.login.LoginScreen
import com.poli.prevendasomie.presentation.main_screen.MainScreen

@Composable
fun SetupNavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination =  Screen.MainScreen.route
    ){

        composable("login_screen"){
            LoginScreen(navController = navController)
        }
        composable("main_screen") {
            MainScreen(navController = navController)
        }
        composable("client_list_screen") {
            ClientListScreen(navController = navController)
        }
        composable(
            route = Screen.ClientDetailScreen.route + "/{codigoClienteOmie}",
            arguments = listOf(navArgument("codigoClienteOmie"){type = NavType.StringType})
        ){
                entry ->
            ClientDetailScreen(
                navController = navController,
                codigoClienteOmie = entry.arguments!!.getString("codigoClienteOmie")!! )
        }
    }
}