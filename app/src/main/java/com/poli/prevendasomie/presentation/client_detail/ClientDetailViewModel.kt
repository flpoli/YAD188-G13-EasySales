package com.poli.prevendasomie.presentation.client_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.common.Env.APP_KEY
import com.poli.prevendasomie.common.Env.APP_SECRET
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.repository.ClientsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientDetailViewModel @Inject constructor(

    private val repository: ClientsRepository

) : ViewModel() {

    val codClientOmie: String = ""

    fun loadClientByCode() {

        viewModelScope.launch{

            val result = repository.getClientByCode(
                Request.ClientByCodeRequest(
                    "ConsultarCliente",
                    APP_KEY,
                    APP_SECRET,
                    listOf(Param.ParamConsultarCliente(codClientOmie))

                )
            )


            when(result) {

                is Resource.Success -> {
                    println("foi?")
                }
                is Resource.Error -> {
                    println("Error loading???? ClientDetail")
                    println("Result? \n ${result.message}")
                }
                else -> {println("else?")}
            }
        }




    }

}