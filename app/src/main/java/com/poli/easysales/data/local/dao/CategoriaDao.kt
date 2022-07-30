package com.poli.easysales.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.easysales.data.local.entities.categorias.CategoriaEntity

@Dao
interface CategoriaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoria(categoria: CategoriaEntity)

    @Query("SELECT * FROM categorias")
    fun getCategorias(): List<CategoriaEntity>
}