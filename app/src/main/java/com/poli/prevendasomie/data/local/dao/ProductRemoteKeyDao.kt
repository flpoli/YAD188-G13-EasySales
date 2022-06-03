package com.poli.prevendasomie.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.common.Constants.PRODUCTS_KEY_TABLE
import com.poli.prevendasomie.data.local.entities.ProductsRemoteKeys

@Dao
interface ProductRemoteKeyDao {

    @Query("SELECT * FROM $PRODUCTS_KEY_TABLE ORDER BY id ASC")
    suspend fun getRemoteKeys(): List<ProductsRemoteKeys>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(keys: List<ProductsRemoteKeys>)

    @Query("DELETE FROM $PRODUCTS_KEY_TABLE")
    suspend fun deleteAllRemoteKeys()
}
