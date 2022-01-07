package com.poli.prevendasomie.presentation.client_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.models.ClientListEntry
import com.poli.prevendasomie.repository.ClientsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ClientListViewModel @Inject constructor(
    private val repository: ClientsRepository
): ViewModel(){

    private val clientList = mutableStateOf<List<ClientListEntry>>(listOf())


    init {
        loadClientList()
    }




    private fun loadClientList(){

        viewModelScope.launch{

            val result = repository.getClientList()

            when(result){
                is Resource.Success ->{

                    val clientEntries = result.data?.clientesCadastro?.mapIndexed {
                            index, it -> {
                                ClientListEntry(
                                    it.cnpjCpf,
                                    it.razaoSocial,
                                    it.nomeFantasia
                                )
                            }

                    }

                    //clientList.value += clientEntries



                }
                is Resource.Error -> {
                    println("Error loading???? ClientListViewModel")
                    println("Result? \n ${result.message}")
                }
            }

        }


    }


}