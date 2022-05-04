package com.poli.prevendasomie.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto

@Dao
interface OrdersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistOrderList(orders: List<PedidoVendaProduto>)

    @Query("SELECT * FROM orders_table")
    fun getAllOrders(): PagingSource<Int, PedidoVendaProduto>

    @Query("DELETE FROM orders_table")
    suspend fun deleteAllOrders()

    @Query("SELECT COUNT(ID) from orders_table")
    suspend fun getOrdersCount(): Int


    /***************************************************************/
    @Query("SELECT * FROM orders_table")
    fun getAllOrdersWihoutPagination(): List<PedidoVendaProduto>

    @Query("SELECT * FROM orders_table WHERE id = :id")
    fun selectOrderById(id: Int): PedidoVendaProduto

    /**************************************************************/
}
