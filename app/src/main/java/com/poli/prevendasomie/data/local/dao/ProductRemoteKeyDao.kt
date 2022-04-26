package com.poli.prevendasomie.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.data.local.entities.ProductsRemoteKeys

@Dao
interface ProductRemoteKeyDao {

    @Query("SELECT * FROM products_keys ORDER BY id ASC")
    suspend fun getRemoteKeys(): List<ProductsRemoteKeys>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(keys: List<ProductsRemoteKeys>)

    @Query("DELETE FROM products_keys")
    suspend fun deleteAllRemoteKeys()
}
