package com.poli.prevendasomie.presentation.main_screen.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.poli.prevendasomie.navigation.Screen

@Composable
fun FabButton(navController: NavController) {

//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(20.dp),
//        verticalArrangement = Arrangement.Bottom,
//        horizontalAlignment = Alignment.End
//    ) {
//
//    }

    FloatingActionButton(

        onClick = { navController.navigate(Screen.ClientFormScreen.route) },
        modifier = Modifier

    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = null
        )
    }
}
