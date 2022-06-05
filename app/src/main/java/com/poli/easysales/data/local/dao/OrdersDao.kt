package com.poli.easysales.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.easysales.common.Constants.ORDERS_TABLE
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

@Dao
interface OrdersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistOrderList(orders: List<PedidoVendaProduto>)

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

    /**************************************************************/

    /* query to  add client in order */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClientOnOrder(selectedClient: ClientesCadastroEntity)

    /**********************************/
}
