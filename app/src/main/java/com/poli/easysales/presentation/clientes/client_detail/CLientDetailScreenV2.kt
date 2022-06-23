package com.poli.easysales.presentation.clientes.client_detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.poli.easysales.domain.model.clientes.Caracteristica
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.presentation.clientes.client_detail.components.ClientInfoGeral
import com.poli.easysales.presentation.clientes.client_detail.components.ClientOrders
import com.poli.easysales.presentation.clientes.client_detail.components.TabItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(
    pagerState: PagerState,
    client: ClientesCadastro,
    orders: List<PedidoVendaProduto>,
    caracteristicas: List<Caracteristica>,
    modifier: Modifier
) {
    val scope = rememberCoroutineScope()
    val tabList = listOf(TabItem.ClientInfoGeral, TabItem.ClientOrders)

    Surface() {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->

                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    height = 1.dp,
                    color = Color.White
                )
            },
            //modifier = modifier.fillMaxWidth(),

            tabs = {

                tabList.forEachIndexed { index, _ ->

                    Tab(
                        selected = pagerState.currentPage == index,
                        text = {
                            Text(
                                text = tabList[index].title,
                                fontSize = 12.sp
                            )
                        },
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                    )
                }
            }
        )
    }



    TabsContent(
        pagerState = pagerState,
        client = client,
        orders = orders,
        caracteristicas = caracteristicas,
        tabList = tabList
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(
    pagerState: PagerState,
    client: ClientesCadastro,
    orders: List<PedidoVendaProduto>,
    caracteristicas: List<Caracteristica>,
    tabList: List<TabItem>

) {

    HorizontalPager(
        count = tabList.size,
        state = pagerState,
        verticalAlignment = Alignment.Top
    ) {

            page ->
        when (page) {

            0 -> ClientInfoGeral(client, orders, caracteristicas)
            1 -> ClientOrders(orders)
        }
    }
}

@Composable
fun TabsContentScreen(
    screen: @Composable () -> Unit
) {
    screen()
}
