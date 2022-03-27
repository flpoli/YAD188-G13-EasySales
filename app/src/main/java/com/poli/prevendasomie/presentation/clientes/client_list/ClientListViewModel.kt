package com.poli.prevendasomie.presentation.clientes.client_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.domain.model.ClientesCadastro
import com.poli.prevendasomie.domain.use_case.cliente_list.GetClientListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ClientListViewModel
@Inject constructor(
    private val useCase: GetClientListUseCase

) : ViewModel() {

    private var curPage = 0

    val clientList = mutableStateOf<List<ClientesCadastro>>(listOf())

    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)
    private var isSearchStarting = true
    private var cachedClientList = listOf<ClientesCadastro>()
    var isSearching = mutableStateOf(false)

    private val _state = mutableStateOf(ClientListState())
    val state: State<ClientListState> = _state

    init {
        loadClientList()
    }

    fun searchClientList(query: String) {

        val listToSearch = if (isSearchStarting) {
            clientList.value
        } else {
            cachedClientList
        }

//        viewModelScope.launch(Dispatchers.Default) {
//
//            if (query.isEmpty()) {
//                clientList.value = cachedClientList
//                isSearching.value = false
//                return@launch
//            }
//
//            val results = listToSearch.filter {
//                it.nomeFantasia?.contains(query.trim(), ignoreCase = true) ?: "
//            }
//
//            if (isSearchStarting) {
//                cachedClientList = clientList.value
//                isSearchStarting = false
//            }
//            clientList.value = results
//            isSearching.value = true
//        }
    }

    fun loadClientList() {

        useCase().onEach { result ->

            when (result) {

                is Resource.Success -> {

                    _state.value = ClientListState(

                        isLoading = false,
                        clientes = result.data,
                        error = null

                    )

                    println(result.data)
                }

                is Resource.Loading -> {

                    _state.value = ClientListState(
                        isLoading = true
                    )
                }

                is Resource.Error -> {
                    _state.value = ClientListState(

                        error = result.message ?: "An unexpected error occurred"

                    )
                }
            }
        }.launchIn(viewModelScope)

//        viewModelScope.launch{
//            when(result){
//                is Resource.Success ->{
//
//                    val clientEntries = result.data?.clientesCadastro?.onEach {
//
//                        it -> ClientesCadastroEntry(it.nomeFantasia)
//                    }
//
//                    if (clientEntries != null) {
//                        clientList.value += clientEntries
//                    }
//
//                    curPage++
//                    loadError.value = ""
//                    isLoading.value = false
//                    println("Parei? ViewModel. CurPage: $curPage")
//                }
//                is Resource.Error -> {
//
//                    loadError.value = result.message!!
//                    isLoading.value = false
//                    println("Error loading???? ClientListViewModel")
//                    println("Result? \n ${result.message}")
//                }
//                else -> {println("else?")}
//            }
//        }
    }
}
