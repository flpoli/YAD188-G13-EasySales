package com.poli.easysales.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
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
import com.poli.easysales.presentation.components.NavDrawer
import com.poli.easysales.presentation.login.LoginScreen
import com.poli.easysales.presentation.main_screen.MainScreen
import com.poli.easysales.presentation.main_screen.components.BottomNavigationBar
import com.poli.easysales.presentation.main_screen.components.FabButton
import com.poli.easysales.presentation.main_screen.components.TopBar
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
import kotlinx.coroutines.launch

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

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {

            if (
                navBackStackEntry?.destination?.route != Screen.LoginScreen.route &&
                navBackStackEntry?.destination?.route != Screen.SignUpScreen.route
            ) {
                TopBar(
                    navController = navController,
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }

                )
            }
        },

        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {

            NavDrawer(
                navController = navController,
                preferences = preferences,
                scope = scope,
                scaffoldState = scaffoldState
            )
        },

        bottomBar = {
            if (
                navBackStackEntry?.destination?.route != Screen.LoginScreen.route &&
                navBackStackEntry?.destination?.route != Screen.SignUpScreen.route
            ) {
                BottomNavigationBar(navController = navController)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        floatingActionButton = {

            if (
                navBackStackEntry?.destination?.route != Screen.LoginScreen.route &&
                navBackStackEntry?.destination?.route != Screen.SignUpScreen.route &&
                navBackStackEntry?.destination?.route != Screen.MainScreen.route
            ) {

                FabButton(navController = navController)
            }
        }

    ) {

        NavHost(
            navController = navController,
            startDestination = if (isLogged) { Screen.MainScreen.route } else { Screen.LoginScreen.route }
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
                MainScreen(navController = navController)
            }
            composable(Screen.ClientListScreen.route) {
                ClientListScreen(navController = navController)
            }
            composable(
                route = Screen.ClientDetailScreen.route,
                arguments = listOf(
                    navArgument("clientId") {
                        type = NavType.LongType
                    }
                )
            ) {

                ClientDetailScreen(navController = navController)
            }

            composable(Screen.ProductListScreen.route) {
                ProductListScreen(navController = navController)
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
                    scaffoldState = scaffoldState
                )
            }

            composable(Screen.OrdersListScreen.route) {
                OrdersListScreen(navController = navController)
            }

            composable(
                route = Screen.OrderDetailScreen.route,
                arguments = listOf(
                    navArgument("orderId") {
                        type = NavType.LongType
                    }
                )
            ) {
                OrderDetailScreen(navController = navController)
            }

            composable(Screen.OrderFormScreen.route) {

                OrdersFormScreen(navController = navController, onNavigate = navController::navigate)
            }

            composable(Screen.ClientSelectionScreen.route) {
                ClientSelectionScreen(navController = navController, /*onNavigateUp = { navController.navigateUp() }*/)
            }

            composable(Screen.ProductSelectionScreen.route) {
                ProductSelectionScreen(navController = navController)
            }
        }
    }
}
