package com.poli.prevendasomie.presentation.produtos.productslist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.pagingsource.ProductsSearchSource
import com.poli.prevendasomie.data.remote.responses.produtos.ProdutoServicoCadastroDto
import com.poli.prevendasomie.domain.model.produtos.ListarProdutos
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.usecase.UseCases
import com.poli.prevendasomie.domain.usecase.products.GetProductsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val useCase: UseCases
) : ViewModel() {

    private val _state = mutableStateOf(ProductsListState())
    val state: State<ProductsListState> = _state



        val produtos = useCase.getProductListUseCase()







}
