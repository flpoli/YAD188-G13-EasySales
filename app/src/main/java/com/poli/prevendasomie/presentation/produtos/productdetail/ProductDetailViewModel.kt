package com.poli.prevendasomie.presentation.produtos.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel
@Inject constructor(
    private val useCase: UseCases,
    savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _selectedProduct: MutableStateFlow<ProdutoServicoCadastro?> = MutableStateFlow(null)
    val selectedProduct: StateFlow<ProdutoServicoCadastro?> = _selectedProduct

    init {

        viewModelScope.launch {

            val productId = savedStateHandle.get<Long>("productId")

            _selectedProduct.value = productId?.let {

                useCase.getSelectedProduct(productId = productId)
            }
        }
    }
}
