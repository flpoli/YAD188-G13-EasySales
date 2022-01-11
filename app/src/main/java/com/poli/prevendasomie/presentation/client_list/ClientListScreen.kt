package com.poli.prevendasomie.presentation.client_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // muito importante ao utilizar "by remember"
import com.poli.prevendasomie.R
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.data.remote.responses.ClientesCadastro
import com.poli.prevendasomie.presentation.client_list.components.ClientEntry
import com.poli.prevendasomie.presentation.client_list.components.ClientListItem
import com.poli.prevendasomie.presentation.client_list.components.ClientRow
import com.poli.prevendasomie.presentation.client_list.components.SearchBar

@Composable
fun ClientListScreen(
    navController: NavController,
    viewModel: ClientListViewModel = hiltViewModel()
) {

    ClientListItem(navController = navController)
}





