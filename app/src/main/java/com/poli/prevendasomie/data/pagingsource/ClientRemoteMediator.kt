package com.poli.prevendasomie.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.poli.prevendasomie.domain.model.ClientesCadastro

@ExperimentalPagingApi
class ClientRemoteMediator: RemoteMediator<Int, ClientesCadastro>() {
    override suspend fun initialize(): InitializeAction {
        return super.initialize()
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ClientesCadastro>
    ): MediatorResult {
        TODO("Not yet implemented")
    }
}