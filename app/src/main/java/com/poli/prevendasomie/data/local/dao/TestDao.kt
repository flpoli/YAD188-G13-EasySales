package com.poli.prevendasomie.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.poli.prevendasomie.data.local.entities.pedidos.relationtest.PedidoCliente

@Dao
interface TestDao {

    @Transaction
    @Query("SELECT * FROM orders_table_test")
    fun getPedidoECliente(): List<PedidoCliente>
}
