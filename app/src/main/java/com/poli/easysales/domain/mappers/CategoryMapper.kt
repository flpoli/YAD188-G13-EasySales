package com.poli.easysales.domain.mappers

import com.poli.easysales.data.local.entities.categorias.CategoriaEntity
import com.poli.easysales.data.remote.dto.categorias.CategoriaCadastro

fun CategoriaCadastro.toCategEntity(): CategoriaEntity {

    return CategoriaEntity(
        codigo = codigo.orEmpty(),
        descricao = descricao.orEmpty()
    )
}