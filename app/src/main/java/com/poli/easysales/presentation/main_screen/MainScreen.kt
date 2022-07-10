package com.poli.easysales.presentation.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.presentation.components.AppScaffold
import com.poli.easysales.presentation.main_screen.components.GreetingSection
import kotlinx.coroutines.CoroutineScope

@Composable
fun MainScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    preferences: Preferences,
    scope: CoroutineScope
) {

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
        scope = scope,
        preferences = preferences,
        showFab = false

    ) {

        val currentUser = preferences.readUserSession().username.value

        Column(modifier = Modifier.padding(it)) {
            GreetingSection(name = currentUser)
        }
    }
}
