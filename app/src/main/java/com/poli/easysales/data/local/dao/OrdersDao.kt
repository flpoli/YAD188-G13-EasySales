package com.poli.easysales.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.poli.easysales.common.Constants.ORDERS_TABLE
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.local.entities.pedidos.relations.OrderWithDets
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

@Dao
interface OrdersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistOrderList(orders: List<PedidoVendaProduto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistOrder(order: PedidoVendaProduto)

    @Query("SELECT * FROM $ORDERS_TABLE")
    fun getAllOrders(): PagingSource<Int, PedidoVendaProduto>

    @Query("DELETE FROM $ORDERS_TABLE")
    suspend fun deleteAllOrders()

    @Query("SELECT COUNT(ID) from $ORDERS_TABLE")
    suspend fun getOrdersCount(): Int

    /***************************************************************/
    @Query("SELECT * FROM $ORDERS_TABLE")
    fun getAllOrdersWithoutPagination(): List<PedidoVendaProduto>

    @Query("SELECT * FROM $ORDERS_TABLE WHERE codigoPedido = :orderId")
    suspend fun selectOrderById(orderId: Long): PedidoVendaProduto

    @Query("SELECT * FROM $ORDERS_TABLE WHERE codigoCliente = :codigoCliente")
    suspend fun getOrdersForClient(codigoCliente: Long): List<PedidoVendaProduto>

    /**************************************************************/

    @Query("UPDATE $ORDERS_TABLE SET codigoCliente = :codigoCliente WHERE id = :orderId")
    suspend fun insertClientOnOrder(orderId: Int, codigoCliente: Long)

//    @Transaction
//    @Query("SELECT * FROM $ORDERS_TABLE WHERE id = :orderId ")
//    suspend fun getOrderWithDets(orderId: Int): OrderWithDets


//    @Query("UPDATE $ORDERS_TABLE SET codigoProduto = :codigoProduto")
//    suspend fun insertProductOnOrder(orderId: Int, codigoProduto: Long, quantidade: Int, valorUnitario: Double)

    /**********************************/
}

