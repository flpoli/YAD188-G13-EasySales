package com.poli.prevendasomie.navigation

sealed class Screen(val route: String) {

    object MainScreen : Screen("main_screen")
    object ClientListScreen : Screen("client_list_screen")
    object ClientDetailScreen : Screen("client_detail_screen")
    object LoginScreen : Screen("login_screen")
    object SignUpScreen : Screen("signup_screen")
    object ClientFormScreen : Screen("client_form_screen")
    object OrdersListScreen : Screen("order_list_screen")
    object ProductListScreen : Screen("product_list_screen")
}
