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
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.util.Objects.toString
import javax.inject.Inject
import kotlin.Unit.toString


@HiltViewModel
class ClientListViewModel
@Inject constructor(private val repository: ClientsRepository): ViewModel(){

    val clientList = mutableStateOf<List<ClientesCadastro>>(listOf())

    init {
        loadClientList()
    }

    fun loadClientList(){

        viewModelScope.launch{

            val result = repository.getClientList(Request(
                "ListarClientes",
                APP_KEY,
                APP_SECRET,
                listOf(
                    Param(
                        "N",
                        "1",
                        "10"
                    )
                )
            ))
            when(result){
                is Resource.Success ->{
//-------------------------------------------------------------------FUCK \/   forEach X onEach?
                    val clientEntries = result.data?.clientesCadastro?.onEach {

                        it -> ClientesCadastroEntry(it.nomeFantasia)
                    }

                    //println(clientEntries?.get(0)?.cnpjCpf)


                    if (clientEntries != null) {
                        clientList.value += clientEntries
                    }

                    //println(clientList)
                    println(clientList.value[0].nomeFantasia)
                }
                is Resource.Error -> {
                    println("Error loading???? ClientListViewModel")
                    println("Result? \n ${result.message}")
                }
                else -> {println("else?")}
            }

        }


    }


}