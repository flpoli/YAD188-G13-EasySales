package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllProducts(): Flow<PagingData<ProdutoServicoCadastro>>

    fun getAllClients(): Flow<PagingData<ClientesCadastro>>
}
