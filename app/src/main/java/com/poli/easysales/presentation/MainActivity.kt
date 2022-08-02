package com.poli.easysales.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.poli.easysales.data.util.setSentryUser
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.navigation.SetupNavGraph
import com.poli.easysales.ui.theme.PreVendasOmieTheme
import com.poli.easysales.ui.theme.PrimaryColor
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, true)

        val isUserLogged = preferences.readLoginStatus()

        if (isUserLogged) {

            preferences.readUserSession()
            setSentryUser(preferences)
        }

        setContent {

//      TODO      val windowSize = rememberWindowSizeClass()

            PreVendasOmieTheme {

                ConfigureSystemBars()

                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()

                SetupNavGraph(
                    navController = navController,
                    scaffoldState = scaffoldState,
                    isLogged = isUserLogged,
                    scope = scope,
                    preferences = preferences
                )
            }
        }
    }
}
@Composable
private fun ConfigureSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = PrimaryColor,
            darkIcons = useDarkIcons,
        )
    }
}