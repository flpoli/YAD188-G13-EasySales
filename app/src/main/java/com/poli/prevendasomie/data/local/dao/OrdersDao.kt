package com.poli.prevendasomie.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.data.local.entities.pedidos.PedidoVendaEntity

@Dao
interface OrdersDao {

    @Query("SELECT * FROM orders_table")
    fun getAllOrders(): PagingSource<Int, PedidoVendaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistOrderList(orders: List<PedidoVendaEntity>)

    @Query("DELETE FROM orders_table")
    suspend fun deleteAllOrders()

    @Query("SELECT COUNT(ID) from orders_table")
    suspend fun getOrdersCount(): Int
}