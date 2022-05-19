package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl
@Inject constructor(private val db: ErpDatabase) : LocalDataSource {

    private val clientDao = db.clientDao()
    private val orderDao = db.ordersDao()

    override suspend fun getSelectedClient(clientId: Int): ClientesCadastro {

        return clientDao.getClientById(id = clientId)
    }

    override fun getNonPaginatedClients(): Flow<List<ClientesCadastro>> {

        return clientDao.getNonPaginatedClients()
    }

    override suspend fun insertSelectedCliente(selectedClient: ClientesCadastro) {

        orderDao.insertClientOnOrder(selectedClient)
    }
}
