package com.poli.prevendasomie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import com.poli.prevendasomie.domain.repository.Preferences
import com.poli.prevendasomie.navigation.SetupNavGraph
import com.poli.prevendasomie.ui.theme.PreVendasOmieTheme
import dagger.hilt.android.AndroidEntryPoint
import io.sentry.Sentry
import io.sentry.UserFeedback
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isUserLogged = preferences.readLoginStatus()

        if(isUserLogged) {

            preferences.readUserSession()
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
