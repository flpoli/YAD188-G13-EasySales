package com.poli.prevendasomie.presentation.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.poli.prevendasomie.presentation.Screen
import com.poli.prevendasomie.presentation.main_screen.components.Features
import com.poli.prevendasomie.presentation.main_screen.components.GreetingSection
import com.poli.prevendasomie.presentation.main_screen.components.TopNavBar



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


