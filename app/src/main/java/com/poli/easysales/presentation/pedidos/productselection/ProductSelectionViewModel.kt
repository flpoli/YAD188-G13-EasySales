package com.poli.easysales.presentation.pedidos.productselection

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.easysales.core.UiEvent
import com.poli.easysales.domain.mappers.toProdutoModel
import com.poli.easysales.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ProductSelectionViewModel
@Inject constructor(
    private val useCase: UseCases,
    private val savedStateHandle: SavedStateHandle

    ) : ViewModel() {

    init {
        loadProductList()
    }

    var state by mutableStateOf(ProductSelectionState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

//    var selecionados: List<SelectableProductUiState> = listOf(SelectableProductUiState())



    fun onEvent(event: ProductSelectionEvent) {

        when (event) {

            is ProductSelectionEvent.OnAmountForProductChange -> {

                state = state.copy(
                    selectableProduct = state.selectableProduct.map {

                        if(it.produto == event.produto) {

                            it.copy(amount = event.amount)

                        } else it

                    }
                )
            }

            is ProductSelectionEvent.OnSelectProduct -> {

                state = state.copy(
                    selectableProduct = state.selectableProduct.map {

                        if(it.produto == event.produto) {

                            it.copy(isSelected = !it.isSelected)

                        } else it

                    }

                )

                Log.d("ViewModel - OnSelectProduct", "${state}")

            }

            is ProductSelectionEvent.OnFinishSelection -> {


//                state = state.copy(
//                    selectableProduct = state.selectableProduct.filter { it.isSelected }
//                )

                savedStateHandle.set("produtos", state.selectableProduct.filter { it.isSelected })

//                selecionados =  state.selectableProduct.filter { it.isSelected }

                Log.d("sabedStateHandle - OnSelectProduct", "${savedStateHandle.get<SelectableProductUiState>("produtos")}")

            }

        }

    }

    fun loadProductList() {

        viewModelScope.launch {

            useCase.getProductListForSelection().collect { it ->

                state = state.copy(
                    isLoading = false,
                    selectableProduct = it.map { SelectableProductUiState(it.toProdutoModel()) }
                )
            }
        }
    }
}
