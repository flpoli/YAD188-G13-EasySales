package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.mappers.toClientModel
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class LocalDataSourceImpl
@Inject constructor(private val db: ErpDatabase) : LocalDataSource {

    private val clientDao = db.clientDao()
    private val orderDao = db.ordersDao()

    override suspend fun getSelectedClient(clientId: Int): ClientesCadastroEntity {

        return clientDao.getClientById(id = clientId)
    }

    override fun getNonPaginatedClients(): Result<List<ClientesCadastroEntity>> {

        return clientDao.getNonPaginatedClients()


        }

    override suspend fun insertSelectedCliente(selectedClient: ClientesCadastroEntity) {

        orderDao.insertClientOnOrder(selectedClient)
    }
}



