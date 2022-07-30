package com.poli.easysales.domain.repository

import com.poli.easysales.data.local.entities.categorias.CategoriaEntity

interface CategoriaRepository {

    suspend fun getCategoryList(): List<CategoriaEntity>
    suspend fun insertCategory(category: CategoriaEntity)

}