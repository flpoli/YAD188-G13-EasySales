package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl
@Inject constructor(private val db: ErpDatabase) : LocalDataSource {

    private val clientDao = db.clientDao()
    private val productDao = db.productsDao()
    private val orderDao = db.ordersDao()

    override suspend fun getSelectedClient(clientId: Long): ClientesCadastroEntity {

        return clientDao.getClientById(id = clientId)
    }

    override fun getNonPaginatedClients(): Flow<List<ClientesCadastroEntity>> {

        return clientDao.getNonPaginatedClients()
    }

    override suspend fun getSelectedProduct(productId: Long): ProdutoServicoCadastro {

        return productDao.getProductById(id = productId)
    }

    override suspend fun insertSelectedCliente(selectedClient: ClientesCadastroEntity) {

        orderDao.insertClientOnOrder(selectedClient)
    }
}
