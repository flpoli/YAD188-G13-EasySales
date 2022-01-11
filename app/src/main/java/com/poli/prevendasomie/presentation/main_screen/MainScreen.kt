package com.poli.prevendasomie.presentation.main_screen

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.poli.prevendasomie.presentation.Screen
import com.poli.prevendasomie.presentation.client_list.ClientListScreen
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun MainScreen(
    navController: NavController,
    //viewModel: null = HiltViewModel() // null by now
) {


    Button(onClick  = {navController.navigate(Screen.ClientListScreen.route)}){
        Text("nhai")
    }

}


//@Composable
//fun Button(
//    onCLick: (() -> Unit)?,
//    modifier: Modifier = Modifier
//){
//    Text("Clientes")
//}