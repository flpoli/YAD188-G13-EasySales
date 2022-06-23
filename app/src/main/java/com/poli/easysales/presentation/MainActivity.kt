package com.poli.easysales.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.poli.easysales.data.util.setSentryUser
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.navigation.SetupNavGraph
import com.poli.easysales.ui.theme.PreVendasOmieTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isUserLogged = preferences.readLoginStatus()

        if (isUserLogged) {

            preferences.readUserSession()
            setSentryUser(preferences)
        }

        setContent {
            PreVendasOmieTheme {

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
