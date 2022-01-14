package com.poli.prevendasomie.presentation.client_detail

import androidx.lifecycle.ViewModel
import com.poli.prevendasomie.common.Env.APP_KEY
import com.poli.prevendasomie.common.Env.APP_SECRET
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.Test
import com.poli.prevendasomie.repository.ClientsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ClientDetailViewModel @Inject constructor(

    private val repository: ClientsRepository

): ViewModel() {

    val codClientOmie: String = ""

    fun loadClientByCode(){

        val result = repository.findClientByCode(
            Request(
                "ConsultarCliente",
                APP_KEY,
                APP_SECRET,
                Test.ParamConsultarCliente(codClientOmie)

                ))
            )
        )

    }

}