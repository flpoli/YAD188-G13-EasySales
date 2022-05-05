package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl
@Inject constructor(private val db: ErpDatabase) : LocalDataSource {

    private val clientDao = db.clientDao()

    override suspend fun getSelectedClient(clientId: Int): ClientesCadastro {

        return clientDao.getClientById(id = clientId)
    }
}
