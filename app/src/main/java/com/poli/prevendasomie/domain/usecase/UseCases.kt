package com.poli.prevendasomie.domain.usecase

import com.poli.prevendasomie.domain.usecase.clients.GetClientListUseCaseImpl
import com.poli.prevendasomie.domain.usecase.clients.IncluirClienteUseCase
import com.poli.prevendasomie.domain.usecase.products.GetProductsListUseCase

data class UseCases(

    val getProductListUseCase: GetProductsListUseCase

)
