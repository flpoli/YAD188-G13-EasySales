package com.poli.easysales.data.repository

import com.poli.easysales.data.local.ErpDatabase
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.repository.LocalDataSource
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

    override fun getProductsForSelection(): Flow<List<ProdutoEntity>> {
        return productDao.getProductsForSelection()
    }

    override suspend fun getSelectedProduct(productId: Long): ProdutoEntity {

        return productDao.getProductById(id = productId)
    }

    override suspend fun insertSelectedCliente(selectedClient: ClientesCadastroEntity) {

        orderDao.insertClientOnOrder(selectedClient)
    }

    override suspend fun getOrdersForClient(codigoClient: Long): List<PedidoVendaProduto> {

        return orderDao.getOrdersForClient(codigoClient)
    }

    override suspend fun getOrderById(orderId: Long): PedidoVendaProduto {

        return orderDao.selectOrderById(orderId = orderId)
    }
}
