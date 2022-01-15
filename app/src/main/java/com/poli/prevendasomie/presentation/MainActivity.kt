package com.poli.prevendasomie.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.poli.prevendasomie.presentation.client_detail.ClientDetailScreen
import com.poli.prevendasomie.presentation.client_list.ClientListScreen
import com.poli.prevendasomie.presentation.main_screen.MainScreen
import com.poli.prevendasomie.ui.theme.PreVendasOmieTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreVendasOmieTheme {

                Surface(color = MaterialTheme.colors.background) {

                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "vendas") },
                                navigationIcon = {
                                    IconButton(onClick = { /* doSomething() */ }) {
                                        Icon(Icons.Filled.Menu, contentDescription = null)
                                    }
                                }
                            )
                        }
                    ){



                val navController = rememberNavController()


                NavHost(
                    navController = navController,
                    startDestination = "main_screen"
                ) {

                    composable("main_screen") {
                        MainScreen(navController = navController)
                    }
                    composable("client_list_screen") {
                        ClientListScreen(navController = navController)
                    }
                    composable("client_detail_screen"){
                        ClientDetailScreen(navController = navController)
                    }
                }
            }
        }
    }
}
}
}

