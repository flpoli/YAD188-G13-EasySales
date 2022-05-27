package com.poli.prevendasomie.presentation.pedidos.productselection

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.domain.mappers.toProdutoModel
import com.poli.prevendasomie.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductSelectionViewModel
@Inject constructor(private val useCase: UseCases): ViewModel() {

    init {
        loadProductList()
    }

    var state by mutableStateOf(ProductSelectionState())

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    private fun loadProductList(){

        viewModelScope.launch {

            useCase.getProductListForSelection().collect {

                state = state.copy(
                    isLoading = false,
                    selectableProduct = it.map {SelectableProductUiState(it.toProdutoModel())}
                )

            }





        }

    }

}