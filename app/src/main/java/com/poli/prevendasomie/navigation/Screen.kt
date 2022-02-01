package com.poli.prevendasomie.navigation

sealed class Screen(val route: String) {

    object MainScreen: Screen("main_screen")
    object ClientListScreen: Screen("client_list_screen")
    object ClientDetailScreen: Screen("client_detail_screen")
    object LoginScreen: Screen("login_screen")

}