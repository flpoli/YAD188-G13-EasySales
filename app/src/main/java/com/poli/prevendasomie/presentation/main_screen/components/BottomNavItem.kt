package com.poli.prevendasomie.presentation.main_screen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Sell
import androidx.compose.ui.graphics.vector.ImageVector
import com.poli.prevendasomie.navigation.Screen

sealed class BottomNavItem(
    var title: String,
    var icon: ImageVector,
    var screenRoute: String
){


    object Home: BottomNavItem("Home", Icons.Filled.Home, Screen.MainScreen.route )
    object Clientes: BottomNavItem("Clientes", Icons.Filled.Contacts, Screen.ClientListScreen.route )
    object Produtos: BottomNavItem("Produtos", Icons.Filled.AllInbox, Screen.ProductListScreen.route )
    object Pedidos: BottomNavItem("Pedidos", Icons.Filled.Sell, Screen.OrdersListScreen.route )

}
