package com.poli.easysales.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.easysales.common.Constants.ORDERS_KEY_TABLE
import com.poli.easysales.data.local.entities.pedidos.OrdersRemoteKeys

@Dao
interface OrdersRemoteKeyDao {

    @Query("SELECT * FROM $ORDERS_KEY_TABLE ORDER BY id ASC")
    suspend fun getRemoteKeys(): List<OrdersRemoteKeys>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(keys: List<OrdersRemoteKeys>)

    @Query("DELETE FROM $ORDERS_KEY_TABLE")
    suspend fun deleteAllRemoteKeys()
}
