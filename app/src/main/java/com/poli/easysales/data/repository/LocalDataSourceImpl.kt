package com.poli.easysales.data.repository

import com.poli.easysales.data.local.ErpDatabase
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.local.entities.produtos.ProdutoVendaEntity
import com.poli.easysales.domain.mappers.toClientEntity
import com.poli.easysales.domain.mappers.toPedidoEntity
import com.poli.easysales.domain.mappers.toPedidoModel
import com.poli.easysales.domain.model.clientes.ClientesCadastro
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

    override fun getProductsForSelection(): Flow<List<ProdutoVendaEntity>> {
        return productDao.getProductsForSelection()
    }

    override suspend fun getSelectedProduct(productId: Long): ProdutoVendaEntity {

        return productDao.getProductById(id = productId)
    }

    override suspend fun getOrdersForClient(codigoClient: Long): List<PedidoVendaProduto> {

        return orderDao.getOrdersForClient(codigoClient).map { it.toPedidoModel() }
    }

    override suspend fun getOrderById(orderId: Long): PedidoVendaProduto {

        return orderDao.selectOrderById(orderId = orderId).toPedidoModel()
    }

    override suspend fun insertNewOrder(order: PedidoVendaProduto) {
        orderDao.persistOrder(order.toPedidoEntity())
    }

    override suspend fun insertNewClient(client: ClientesCadastro) {
        clientDao.insertNewClient(client.toClientEntity())
    }
}
