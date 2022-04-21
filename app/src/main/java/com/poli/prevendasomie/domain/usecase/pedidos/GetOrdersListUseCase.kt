package com.poli.prevendasomie.domain.usecase.pedidos

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.domain.model.ListarPedidos
import kotlinx.coroutines.flow.Flow

interface GetOrdersListUseCase {

    operator fun invoke(): Flow<Resource<ListarPedidos>>
}
