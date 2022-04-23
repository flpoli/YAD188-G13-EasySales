package com.poli.prevendasomie.domain.usecase.products

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsListUseCaseImpl
@Inject constructor(private val repository: ProductsRepository) : GetProductsListUseCase {

    override fun invoke(): Flow<PagingData<ProdutoServicoCadastro>>? {

        return repository.getProductList()

//        try {
//            emit(Resource.Loading<ListarProdutos>())
//            val produtos = repository.getProductList(request)
//            emit(Resource.Success(produtos))
//        } catch (e: HttpException) {
//            emit(Resource.Error<ListarProdutos>(e.localizedMessage ?: R.string.on_http_error.toString()))
//        } catch (e: IOException) {
//            emit(Resource.Error<ListarProdutos>(e.localizedMessage ?: R.string.on_http_error.toString()))
//        }
    }
}
