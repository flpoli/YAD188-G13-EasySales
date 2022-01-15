package com.poli.prevendasomie.presentation.client_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.common.Env.APP_KEY
import com.poli.prevendasomie.common.Env.APP_SECRET
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.models.ClientListEntry
import com.poli.prevendasomie.data.models.ClientesCadastroEntry
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ClientesCadastro
import com.poli.prevendasomie.repository.ClientsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.Objects.toString
import javax.inject.Inject
import kotlin.Unit.toString


@HiltViewModel
class ClientListViewModel
@Inject constructor(private val repository: ClientsRepository): ViewModel(){


    private var curPage = 0

    val clientList = mutableStateOf<List<ClientesCadastro>>(listOf())

    //TODO: Pagination impl
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)
    private var isSearchStarting = true
    private var cachedClientList = listOf<ClientesCadastro>()
    var isSearching = mutableStateOf(false)



    init {
        loadClientList()
    }

    fun searchClientList(query: String){

        val listToSearch = if(isSearchStarting){
            clientList.value
        }else{
            cachedClientList
        }

        viewModelScope.launch(Dispatchers.Default){

            if(query.isEmpty()){
                clientList.value = cachedClientList
                isSearching.value = false
                return@launch
            }

            val results = listToSearch.filter {
                it.nomeFantasia.contains(query.trim(), ignoreCase = true)
            }

            if(isSearchStarting){
                cachedClientList = clientList.value
                isSearchStarting = false
            }
            clientList.value = results
            isSearching.value = true
        }


    }

    fun loadClientList(){

        viewModelScope.launch{

            val result = repository.getClientList(
                Request.ListClientsRequest(
                    "ListarClientes",
                    APP_KEY,
                    APP_SECRET,
                    listOf(
                        Param.ParamListarClientes(
                            "N",
                            curPage.toString(), // int na data class..? maybe
                            "10"
                        )
                    )
                )
            )
            when(result){
                is Resource.Success ->{

                                                                     //TODO: Search about this difference ¬¬
//-------------------------------------------------------------------FUCK \/   forEach X onEach?
                    val clientEntries = result.data?.clientesCadastro?.onEach {

                        it -> ClientesCadastroEntry(it.nomeFantasia)
                    }

                    if (clientEntries != null) {
                        clientList.value += clientEntries
                    }

                    curPage++
                    loadError.value = ""
                    isLoading.value = false
                    println("Parei? ViewModel. CurPage: $curPage")
                }
                is Resource.Error -> {

                    loadError.value = result.message!!
                    isLoading.value = false
                    println("Error loading???? ClientListViewModel")
                    println("Result? \n ${result.message}")
                }
                else -> {println("else?")}
            }

        }


    }


}