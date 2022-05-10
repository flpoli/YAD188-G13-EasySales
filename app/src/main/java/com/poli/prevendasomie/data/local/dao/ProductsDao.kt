package com.poli.prevendasomie.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistProductList(produtos: List<ProdutoServicoCadastro>)

    @Query("SELECT * FROM products_tb")
    fun getAllProducts(): PagingSource<Int, ProdutoServicoCadastro>

    @Query("DELETE FROM products_tb")
    suspend fun deleteAllProducts()

    @Query("SELECT COUNT(ID) from products_tb")
    suspend fun getProductsCount(): Int
}
