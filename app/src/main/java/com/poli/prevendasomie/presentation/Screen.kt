package com.poli.prevendasomie.presentation

sealed class Screen(val route: String) {

    object MainScreen: Screen("main_screen")
    object ClientListScreen: Screen("client_list_screen")
    object ClientDetailScreen: Screen("client_detail_screen")

}