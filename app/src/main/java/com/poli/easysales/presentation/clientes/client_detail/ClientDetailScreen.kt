package com.poli.easysales.presentation.clientes.client_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.presentation.clientes.client_detail.components.InfoBox
import com.poli.easysales.presentation.components.AppScaffold
import com.poli.prevendasomie.R
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ClientDetailScreen(
    navController: NavHostController,
    scope: CoroutineScope,
    preferences: Preferences,
    scaffoldState: ScaffoldState,
    viewModel: ClientDetailViewModel = hiltViewModel(),

) {

    val orders by viewModel.orders.collectAsState()
    val caracteristicas by viewModel.caracteristicas.collectAsState()
    val selectedClient by viewModel.selectedClient.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0)

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
        scope = scope,
        preferences = preferences

    ) {

            paddingValues ->

        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(color = MaterialTheme.colors.surface)
                .fillMaxSize()
        ) {

            selectedClient?.let { client ->

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                ) {
                    InfoBox(
                        title = "Nome",
                        info = client.nomeFantasia ?: stringResource(id = R.string.not_informed),
                        subtitle = client.cnpjCpf ?: stringResource(id = R.string.not_informed)
                    )

                    Tabs(
                        pagerState = pagerState,
                        navController = navController,
                        client = selectedClient!!,
                        orders = orders.orEmpty(),
                        caracteristicas = caracteristicas.orEmpty(),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
