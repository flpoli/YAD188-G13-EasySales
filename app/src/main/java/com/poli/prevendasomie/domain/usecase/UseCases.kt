package com.poli.prevendasomie.domain.usecase

import com.poli.prevendasomie.domain.usecase.clients.GetClientDetailsUseCase
import com.poli.prevendasomie.domain.usecase.clients.GetClientListForSelectionUseCase
import com.poli.prevendasomie.domain.usecase.clients.GetClientListUseCase
import com.poli.prevendasomie.domain.usecase.pedidos.GetOrdersListUseCase
import com.poli.prevendasomie.domain.usecase.pedidos.InsertSelectedClientUseCase
import com.poli.prevendasomie.domain.usecase.products.GetProductsListUseCase

data class UseCases(

    val getProductListUseCase: GetProductsListUseCase,
    val getClientListUseCase: GetClientListUseCase,
    val getOrdersListUseCase: GetOrdersListUseCase,
    val getSelectedClientUseCase: GetClientDetailsUseCase,
    val getClientListForSelectionUseCase: GetClientListForSelectionUseCase,
    val insertSelectedClientUseCase: InsertSelectedClientUseCase

)
