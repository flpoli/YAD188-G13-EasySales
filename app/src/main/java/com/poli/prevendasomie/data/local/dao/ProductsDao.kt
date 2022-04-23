package com.poli.prevendasomie.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

@Dao
interface ProductsDao {

    @Query("SELECT * FROM produtos_table")
    fun getAllProducts(): PagingSource<Int, ProdutoServicoCadastro>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistProductList(produto: List<ProdutoServicoCadastro>)

    @Query("DELETE FROM produtos_table")
    suspend fun deleteAllProducts()
}
