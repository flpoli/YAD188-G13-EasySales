package com.poli.prevendasomie.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.dto.clientes.ClientesCadastroDto
import javax.inject.Inject

class ClientsSearchSource
@Inject constructor(
    private val api: OmieAPI
) : PagingSource<Int, ClientesCadastroDto>() {

    override fun getRefreshKey(state: PagingState<Int, ClientesCadastroDto>): Int? {

        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ClientesCadastroDto> {

        val req = Request.ListClientsRequest(
            param = listOf(
                Param.ParamListarClientes(
                    pagina = params.key.toString(),
                    registrosPorPagina = params.loadSize.toString()
                )
            )
        )

        return try {

            val apiResponse = api.getClientList(req)

            val clientes = apiResponse.clientesCadastro

            if (clientes.isNotEmpty()) {

                LoadResult.Page(
                    data = clientes,
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
