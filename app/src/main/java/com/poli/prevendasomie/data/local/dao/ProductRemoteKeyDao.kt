package com.poli.prevendasomie.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.domain.model.produtos.ProductsRemoteKeys

@Dao
interface ProductRemoteKeyDao {

    @Query("SELECT * FROM products_keys WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): ProductsRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(productRemoteKeys: List<ProductsRemoteKeys>)

    @Query("DELETE FROM products_keys")
    suspend fun deleteAllRemoteKeys()
}
