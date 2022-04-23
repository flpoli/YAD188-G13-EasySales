package com.poli.prevendasomie.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.domain.model.ClientesCadastro
import javax.inject.Inject

@ExperimentalPagingApi
class ClientsRemoteMediator
@Inject constructor(
    api: OmieAPI,
    db: ErpDatabase
) : RemoteMediator<Int, ClientesCadastro>() {

    private val clientDao = db.clientDao()
    private val remoteKeysDao = db.clientRemoteKeyDao()

    override suspend fun initialize(): InitializeAction {
        val currentTime = System.currentTimeMillis()
        val lastUpdated = remoteKeysDao.getRemoteKeys(id = 1).lastUpdated ?: 0L
        val cacheTimeout = 1440
        val diffInMinutes = (currentTime - lastUpdated) / 1000 / 60

        return if (diffInMinutes.toInt() <= cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ClientesCadastro>
    ): MediatorResult {
        TODO("Not yet implemented")
    }
}
