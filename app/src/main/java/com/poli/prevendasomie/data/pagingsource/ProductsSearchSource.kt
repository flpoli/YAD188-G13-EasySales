package com.poli.prevendasomie.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.produtos.ProdutoServicoCadastroDto
import javax.inject.Inject

class ProductsSearchSource
    @Inject constructor(
        private val api: OmieAPI,
        private val req: Request.ListarProdutosRequest
        ): PagingSource<Int, ProdutoServicoCadastroDto>() {


    override fun getRefreshKey(state: PagingState<Int, ProdutoServicoCadastroDto>): Int? {

        return state.anchorPosition

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProdutoServicoCadastroDto> {

        return try {

            val apiResponse = api.getProductList(req)

            val produtos = apiResponse.produtoServicoCadastro

            if(produtos.isEmpty()) {

                LoadResult.Page(
                    data = produtos,
                    prevKey = apiResponse.pagina,
                    nextKey = apiResponse.pagina?.plus(1)
                )

            } else {

                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )

            }
        } catch (e: Exception){

            LoadResult.Error(e)
        }


    }

}