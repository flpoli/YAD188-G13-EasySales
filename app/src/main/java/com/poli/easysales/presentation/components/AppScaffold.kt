package com.poli.easysales.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.presentation.main_screen.components.BottomNavigationBar
import com.poli.easysales.presentation.main_screen.components.FabButton
import com.poli.easysales.presentation.main_screen.components.TopBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppScaffold(

    scaffoldState: ScaffoldState,
    navController: NavHostController,
    scope: CoroutineScope,
    preferences: Preferences,
    showFab: Boolean = true,
    showBottomBar: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {

    Scaffold(

        scaffoldState = scaffoldState,
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {

            NavDrawer(
                navController = navController,
                preferences = preferences,
                scaffoldState = scaffoldState,
                scope = scope
            )
        },

        topBar = {
            TopBar(
                navController = navController,
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        bottomBar = {

            if (showBottomBar) {
                BottomNavigationBar(navController = navController)

            }
        },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,

        floatingActionButton = {

            if (showFab)
                FabButton(navController = navController)
        }
    ) {

        content(it)
    }
}

