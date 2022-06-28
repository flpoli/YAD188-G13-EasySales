package com.poli.easysales.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.presentation.clientes.client_detail.ClientDetailScreen
import com.poli.easysales.presentation.clientes.client_list.ClientListScreen
import com.poli.easysales.presentation.clientes.cliente_form.ClientFormScreen
import com.poli.easysales.presentation.login.LoginScreen
import com.poli.easysales.presentation.main_screen.MainScreen
import com.poli.easysales.presentation.onboarding.OnboardingScreen
import com.poli.easysales.presentation.pedidos.OrdersFormScreen
import com.poli.easysales.presentation.pedidos.clientselection.ClientSelectionScreen
import com.poli.easysales.presentation.pedidos.orderdetail.OrderDetailScreen
import com.poli.easysales.presentation.pedidos.orderlist.OrdersListScreen
import com.poli.easysales.presentation.pedidos.productselection.ProductSelectionScreen
import com.poli.easysales.presentation.produtos.productdetail.ProductDetailScreen
import com.poli.easysales.presentation.produtos.productform.ProductFormScreen
import com.poli.easysales.presentation.produtos.productslist.ProductListScreen
import com.poli.easysales.presentation.signup.SignupScreen
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    isLogged: Boolean,
    scope: CoroutineScope,
    preferences: Preferences

) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavHost(
        navController = navController,
        startDestination = if (isLogged) {
            Screen.MainScreen.route
        } else {
            Screen.LoginScreen.route
        },
        modifier = Modifier.padding()
    ) {

        composable(Screen.OnBoardingScreen.route) {
            OnboardingScreen(navController = navController)
        }

        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.SignUpScreen.route) {
            SignupScreen(
                navController = navController, scaffoldState = scaffoldState
            )
        }
        composable(Screen.MainScreen.route) {
            MainScreen(
                navController = navController,
                preferences = preferences,
                scaffoldState = scaffoldState,
                scope = scope
            )
        }
        composable(Screen.ClientListScreen.route) {
            ClientListScreen(
                navController = navController,
                preferences = preferences,
                scaffoldState = scaffoldState,
                scope = scope
            )
        }
        composable(
            route = Screen.ClientDetailScreen.route,
            arguments = listOf(
                navArgument("clientId") {
                    type = NavType.LongType
                }
            )
        ) {

            ClientDetailScreen(
                navController = navController,
                preferences = preferences,
                scaffoldState = scaffoldState,
                scope = scope
            )
        }

        composable(Screen.ProductListScreen.route) {
            ProductListScreen(
                navController = navController,
                preferences = preferences,
                scaffoldState = scaffoldState,
                scope = scope
            )
        }

        composable(
            route = Screen.ProductDetailScreen.route,
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.LongType
                }
            )
        ) {
            ProductDetailScreen(navController = navController)
        }

        composable(Screen.ProductFormScreen.route) {
            ProductFormScreen()
        }
        composable(Screen.ClientFormScreen.route) {
            ClientFormScreen(
                navController = navController,
                preferences = preferences,
                scaffoldState = scaffoldState,
                scope = scope
            )
        }

        composable(Screen.OrdersListScreen.route) {
            OrdersListScreen(
                navController = navController,
                preferences = preferences,
                scaffoldState = scaffoldState,
                scope = scope
            )
        }

        composable(
            route = Screen.OrderDetailScreen.route,
            arguments = listOf(
                navArgument("orderId") {
                    type = NavType.LongType
                }
            )
        ) {
            OrderDetailScreen(
                navController = navController,
                preferences = preferences,
                scaffoldState = scaffoldState,
                scope = scope
            )
        }

        composable(Screen.OrderFormScreen.route) {

            OrdersFormScreen(
                navController = navController,
                onNavigate = navController::navigate,
                preferences = preferences,
                scaffoldState = scaffoldState,
                scope = scope
            )
        }

        composable(Screen.ClientSelectionScreen.route) {
            ClientSelectionScreen(navController = navController)
        }

        composable(Screen.ProductSelectionScreen.route) {
            ProductSelectionScreen(navController = navController)
        }
    }
}
