package com.poli.prevendasomie.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.common.Constants.PRODUCTS_TABLE
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistProductList(produtos: List<ProdutoServicoCadastro>)

    @Query("SELECT * FROM $PRODUCTS_TABLE")
    fun getAllProducts(): PagingSource<Int, ProdutoServicoCadastro>


    @Query("SELECT * FROM $PRODUCTS_TABLE WHERE codigoProduto = :id")
    suspend fun getProductById(id: Long): ProdutoServicoCadastro

    @Query("DELETE FROM $PRODUCTS_TABLE")
    suspend fun deleteAllProducts()

    @Query("SELECT COUNT(ID) from $PRODUCTS_TABLE")
    suspend fun getProductsCount(): Int
}
