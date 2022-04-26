package com.poli.prevendasomie.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.clientes.toClientesCadastro
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.data.local.entities.ClientsRemoteKeys
import javax.inject.Inject

@ExperimentalPagingApi
class ClientsRemoteMediator
@Inject constructor(
    private val api: OmieAPI,
    private val db: ErpDatabase
) : RemoteMediator<Int, ClientesCadastro>() {

    private val clientDao = db.clientDao()
    private val remoteKeysDao = db.clientRemoteKeyDao()

    override suspend fun initialize(): InitializeAction {
        val currentTime = System.currentTimeMillis()
        val lastUpdated = remoteKeysDao.getRemoteKeys().firstOrNull()?.lastUpdated ?: 0L
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

        try {

            val page = when (loadType) {

                LoadType.REFRESH -> {

                    if (clientDao.getClientsCount() > 0) {

                        return MediatorResult.Success(endOfPaginationReached = true)
                    } else {

                        val initialPage = 1

                        initialPage
                    }
                }
                LoadType.PREPEND -> {
                    return MediatorResult.Success(endOfPaginationReached = true)

                }
                LoadType.APPEND -> {

                    val lastRemoteKey = getLastRemoteKey()

                    if(lastRemoteKey?.nextPage != null) {

                        lastRemoteKey.nextPage

                    } else {

                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                }

            }

            val request = Request.ListClientsRequest(
                param = listOf(
                    Param.ParamListarClientes(
                        pagina = page.toString(),
                        registrosPorPagina = state.config.pageSize.toString()
                    )
                )
            )

            val response = api.getClientList(request)

            if(response.clientesCadastro.isNotEmpty()) {

                db.withTransaction {

                    if(loadType == LoadType.REFRESH) {

                        clientDao.deleteAllClients()
                        remoteKeysDao.deleteAllRemoteKeys()

                    }

                    val prevPage = response.pagina.minus(1)
                    val nextPage = response.pagina.plus(1)

                    val keys = response.clientesCadastro.map {

                        cliente ->

                            ClientsRemoteKeys(
                                id = cliente.id,
                                prevPage = prevPage,
                                nextPage = nextPage,
                                lastUpdated = System.currentTimeMillis()

                            )

                    }

                    val cliente = response.clientesCadastro.map { it.toClientesCadastro() }

                    remoteKeysDao.addAllRemoteKeys(keys)
                    clientDao.persistClientList(cliente)
                }
            }

            return MediatorResult.Success(endOfPaginationReached = response.pagina != null)
        } catch (e: Exception) {

            return MediatorResult.Error(e)
        }
    }

    private suspend fun getLastRemoteKey(): ClientsRemoteKeys? {

        return remoteKeysDao.getRemoteKeys().lastOrNull()
    }
}
