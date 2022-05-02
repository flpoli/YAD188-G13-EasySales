package com.poli.prevendasomie.presentation.produtos.productslist

import androidx.lifecycle.ViewModel
import com.poli.prevendasomie.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    useCase: UseCases
) : ViewModel() {

//    private val _state = mutableStateOf(ProductsListState())
//    val state: State<ProductsListState> = _state

    val produtos = useCase.getProductListUseCase()
}
