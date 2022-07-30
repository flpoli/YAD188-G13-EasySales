package com.poli.easysales.data.repository

import com.poli.easysales.data.local.ErpDatabase
import com.poli.easysales.data.local.entities.categorias.CategoriaEntity
import com.poli.easysales.data.remote.OmieAPI
import com.poli.easysales.data.remote.Param
import com.poli.easysales.data.remote.Request
import com.poli.easysales.domain.mappers.toCategEntity
import com.poli.easysales.domain.repository.CategoriaRepository
import javax.inject.Inject

class CategoryRepositoryImpl
    @Inject constructor(
        private val api: OmieAPI,
        private val db: ErpDatabase
    ): CategoriaRepository {

    override suspend fun insertCategory(category: CategoriaEntity) {

        val request = Request.ListarCategorias(
            param = listOf(Param.ParamListarCategorias(
                1,
                500,
                "S",
                "R"
            )
            )
        )

        api.getCategoryList(request).apply {

            val categ = this.categoriaCadastro?.map { it?.toCategEntity() }

            categ?.onEach {
                if (it != null) {
                    db.categoryDao().insertCategoria(it)
                }

            }
            db.categoryDao().insertCategoria(category)
        }
    }




    override suspend fun getCategoryList(): List<CategoriaEntity> {

        return db.categoryDao().getCategorias()
    }

}