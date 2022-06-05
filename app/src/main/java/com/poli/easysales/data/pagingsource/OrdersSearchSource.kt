package com.poli.easysales.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.poli.easysales.data.remote.OmieAPI
import com.poli.easysales.data.remote.Param
import com.poli.easysales.data.remote.Request
import com.poli.easysales.data.remote.dto.pedidos.PedidoVendaProdutoDto
import javax.inject.Inject

class OrdersSearchSource
@Inject constructor(
    private val api: OmieAPI
) : PagingSource<Int, PedidoVendaProdutoDto>() {

    override fun getRefreshKey(state: PagingState<Int, PedidoVendaProdutoDto>): Int? {

        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PedidoVendaProdutoDto> {

        val req = Request.ListarPedidosRequest(
            param = listOf(
                Param.ParamListarPedidos(
                    pagina = params.key.toString(),
                    registrosPorPagina = params.loadSize.toString()
                )
            )
        )

        return try {

            val apiResponse = api.getOrderList(req)

            val pedidos = apiResponse.pedidoVendaProduto

            if (pedidos.isNotEmpty()) {

                LoadResult.Page(
                    data = pedidos,
                    prevKey = apiResponse.pagina,
                    nextKey = apiResponse.pagina.plus(1)
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
