package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

interface LocalDataSource {

    suspend fun getSelectedClient(clientId: Int): ClientesCadastro
}
