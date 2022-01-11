package com.poli.prevendasomie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.presentation.client_list.ClientListScreen
import com.poli.prevendasomie.presentation.main_screen.MainScreen
import com.poli.prevendasomie.ui.theme.PreVendasOmieTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreVendasOmieTheme {

                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "main_screen"
                    ){

                        composable("main_screen"){
                            MainScreen(navController = navController)
                        }
                        composable("client_list_screen") {
                            ClientListScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

