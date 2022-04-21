package com.poli.prevendasomie.presentation.produtos.productslist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.domain.usecase.products.GetProductsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val useCase: GetProductsListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ProductsListState())
    val state: State<ProductsListState> = _state

    init {
        loadProductsList()
    }

    fun loadProductsList() {

        useCase().onEach {

                result ->

            println(result)

            when (result) {

                is Resource.Success -> {
                    _state.value = ProductsListState(
                        isLoading = false,
                        produtos = result.data,
                        error = null
                    )
                }
                else -> {
                    _state.value = ProductsListState(
                        isLoading = false,
                        produtos = null,
                        error = "ALGO ERRADO ACONTECEU"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
