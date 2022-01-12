package com.poli.prevendasomie.presentation.main_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.poli.prevendasomie.presentation.Screen
import com.poli.prevendasomie.presentation.main_screen.components.Features
import com.poli.prevendasomie.presentation.main_screen.components.GreetingSection
import com.poli.prevendasomie.presentation.main_screen.components.TopNavBar

@ExperimentalFoundationApi
@Composable
fun MainScreen(
    navController: NavController,
    //viewModel: null = HiltViewModel() // null by now
) {


            GreetingSection()
            FeatureSection(listOf())




}


