package com.poli.easysales.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.easysales.common.Constants.PRODUCTS_TABLE
import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistProductList(produtos: List<ProdutoEntity>)

    @Query("SELECT * FROM $PRODUCTS_TABLE")
    fun getAllProducts(): PagingSource<Int, ProdutoEntity>

    @Query("SELECT * FROM $PRODUCTS_TABLE")
    fun getProductsForSelection(): Flow<List<ProdutoEntity>>

    @Query("SELECT * FROM $PRODUCTS_TABLE WHERE codigoProduto = :id")
    suspend fun getProductById(id: Long): ProdutoEntity

    @Query("DELETE FROM $PRODUCTS_TABLE")
    suspend fun deleteAllProducts()

    @Query("SELECT COUNT(ID) from $PRODUCTS_TABLE")
    suspend fun getProductsCount(): Int
}
