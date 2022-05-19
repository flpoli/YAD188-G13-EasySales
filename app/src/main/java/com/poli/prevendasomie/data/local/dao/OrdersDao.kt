package com.poli.prevendasomie.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto

@Dao
interface OrdersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistOrderList(orders: List<PedidoVendaProduto>)

    @Query("SELECT * FROM orders_tb")
    fun getAllOrders(): PagingSource<Int, PedidoVendaProduto>

    @Query("DELETE FROM orders_tb")
    suspend fun deleteAllOrders()

    @Query("SELECT COUNT(ID) from orders_tb")
    suspend fun getOrdersCount(): Int

    /***************************************************************/
    @Query("SELECT * FROM orders_tb")
    fun getAllOrdersWithoutPagination(): List<PedidoVendaProduto>

    @Query("SELECT * FROM orders_tb WHERE id = :id")
    fun selectOrderById(id: Int): PedidoVendaProduto

    /**************************************************************/

    /* query to  add client in order */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClientOnOrder(selectedClient: ClientesCadastro)

    /**********************************/
}
