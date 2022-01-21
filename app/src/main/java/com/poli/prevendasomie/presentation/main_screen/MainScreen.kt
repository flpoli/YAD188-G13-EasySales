package com.poli.prevendasomie.presentation.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.poli.prevendasomie.presentation.main_screen.components.GreetingSection


@Composable
fun MainScreen(
    navController: NavController,
    //viewModel: null = HiltViewModel()
) {

    Column(){
        GreetingSection()
        FeatureSection(navController, Modifier.padding(top = 30.dp))
    }






}


