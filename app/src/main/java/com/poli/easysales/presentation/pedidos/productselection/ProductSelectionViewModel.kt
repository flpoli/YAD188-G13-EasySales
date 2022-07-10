package com.poli.easysales.presentation.pedidos.productselection

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.easysales.core.UiEvent
import com.poli.easysales.domain.mappers.toProdutoModel
import com.poli.easysales.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductSelectionViewModel
@Inject constructor(private val useCase: UseCases) : ViewModel() {

    init {
        loadProductList()
    }

    private var _state by mutableStateOf(ProductSelectionState())
    var state = _state

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun onProductQuantityChanged(quantity: String){

        val currentData = _state.selectableProduct.forEach { it.amount }

    }

    private fun loadProductList() {

        viewModelScope.launch {

            useCase.getProductListForSelection().collect {

                state = state.copy(
                    isLoading = false,
                    selectableProduct = it.map { SelectableProductUiState(it.toProdutoModel()) }
                )
            }
        }
    }
}
