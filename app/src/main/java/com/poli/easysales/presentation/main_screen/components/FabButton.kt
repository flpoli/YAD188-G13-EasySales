package com.poli.easysales.presentation.main_screen.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.poli.easysales.common.Constants.CLIENT_LIST_ROUTE
import com.poli.easysales.common.Constants.ORDER_LIST_ROUTE
import com.poli.easysales.common.Constants.PRODUCT_LIST_ROUTE
import com.poli.easysales.navigation.Screen

@Composable
fun FabButton(navController: NavController) {

    fun navToForm(navController: NavController) {

        if (navController.currentBackStackEntry?.destination?.route == CLIENT_LIST_ROUTE) {
            navController.navigate(Screen.ClientFormScreen.route)
        }
        if (navController.currentBackStackEntry?.destination?.route == PRODUCT_LIST_ROUTE) {
            navController.navigate(Screen.ProductFormScreen.route)
        }
        if (navController.currentBackStackEntry?.destination?.route == ORDER_LIST_ROUTE) {
            navController.navigate(Screen.OrderFormScreen.route)
        }
    }

    FloatingActionButton(

        onClick = { navToForm(navController) },
        modifier = Modifier

    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = null
        )
    }
}
