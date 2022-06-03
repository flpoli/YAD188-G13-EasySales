package com.poli.prevendasomie.domain.usecase.pedidos

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

interface InsertSelectedClientUseCase {

    suspend operator fun invoke(selectedClient: ClientesCadastro)
}
