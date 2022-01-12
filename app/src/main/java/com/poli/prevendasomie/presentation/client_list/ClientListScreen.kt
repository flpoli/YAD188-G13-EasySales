package com.poli.prevendasomie.presentation.client_list

import android.content.Context
import android.graphics.drawable.VectorDrawable
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Upload
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.poli.prevendasomie.R
import com.poli.prevendasomie.presentation.Screen
import com.poli.prevendasomie.presentation.client_list.components.ClientListItem

@Composable
fun ClientListScreen(
    navController: NavController,
    viewModel: ClientListViewModel = hiltViewModel()
) {

    ClientListItem(navController = navController)
    AddClientFab()

}


@Composable
fun AddClientFab() {

Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(20.dp),
    verticalArrangement = Arrangement.Bottom,
    horizontalAlignment = Alignment.End
){
    FloatingActionButton(

        onClick = { /*do something*/},
        modifier = Modifier

    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = null
        )


    }
}



}


