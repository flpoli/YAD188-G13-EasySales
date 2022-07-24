package com.poli.easysales.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.easysales.common.Constants.PRODUCTS_KEY_TABLE
import com.poli.easysales.data.local.entities.produtos.ProductsRemoteKeys

@Dao
interface ProductRemoteKeyDao {

    @Query("SELECT * FROM $PRODUCTS_KEY_TABLE ORDER BY id ASC")
    suspend fun getRemoteKeys(): List<ProductsRemoteKeys>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(keys: List<ProductsRemoteKeys>)

    @Query("DELETE FROM $PRODUCTS_KEY_TABLE")
    suspend fun deleteAllRemoteKeys()
}
