package com.poli.prevendasomie.domain.usecase.products

import com.poli.prevendasomie.R
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.produtos.toListarProdutos
import com.poli.prevendasomie.domain.model.ListarProdutos
import com.poli.prevendasomie.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductsListUseCaseImpl
@Inject constructor(private val repository: ProductsRepository) : GetProductsListUseCase {

    override fun invoke(): Flow<Resource<ListarProdutos>> = flow {

        val request = Request.ListarProdutosRequest(
            param = listOf(
                Param.ParamListarProdutos(
                    pagina = "1", registrosPorPagina = "30"

                )
            )
        )

        try {
            emit(Resource.Loading<ListarProdutos>())
            val produtos = repository.getProductList(request).toListarProdutos()
            println(produtos)
            emit(Resource.Success(produtos))
        } catch (e: HttpException) {
            emit(Resource.Error<ListarProdutos>(e.localizedMessage ?: R.string.on_http_error.toString()))
        } catch (e: IOException) {
            emit(Resource.Error<ListarProdutos>(e.localizedMessage ?: R.string.on_http_error.toString()))
        }
    }
}
