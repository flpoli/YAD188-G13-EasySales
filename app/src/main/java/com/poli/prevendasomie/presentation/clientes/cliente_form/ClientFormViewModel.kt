package com.poli.prevendasomie.presentation.clientes.cliente_form

import androidx.lifecycle.ViewModel
import com.poli.prevendasomie.domain.model.ClientesCadastro
import com.poli.prevendasomie.domain.model.Email
import com.poli.prevendasomie.domain.use_case.clients.IncluirClienteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ClientFormViewModel @Inject constructor(private val useCase: IncluirClienteUseCase): ViewModel() {

    private val _viewState: MutableStateFlow<ClienteFormViewState> =
        MutableStateFlow(ClienteFormViewState.Initial)

    val viewState: StateFlow<ClienteFormViewState> =_viewState

    fun onRegisterClicked(){

        useCase()

    }

    fun onEmailChanged(email: String){
        val currentData = _viewState.value.cliente

        _viewState.value = ClienteFormViewState.Active(
            inputError = null,
            cliente = currentData.withUpdatedEmail(email)
        )

        println(currentData)
    }


    private fun ClientesCadastro.withUpdatedEmail(email: String): ClientesCadastro {
        return this.copy(email = email)
    }
    private fun ClientesCadastro.withUpdatedRazaoSocial(razaoSocial: String):ClientesCadastro{
        return this.copy(razaoSocial = razaoSocial)
    }
    private fun ClientesCadastro.withUpdatedNomeFantasia(nomeFantasia: String): ClientesCadastro{
        return this.copy(nomeFantasia = nomeFantasia)
    }
    private fun ClientesCadastro.withUpdatedCnpjCpf(cnpjCpf: String): ClientesCadastro{
        return this.copy(cnpjCpf = cnpjCpf)
    }
    private fun ClientesCadastro.withUpdatedTelefone1Ddd(telefone1Ddd: String): ClientesCadastro {
        return this.copy(telefone1Ddd = telefone1Ddd)
    }
    private fun ClientesCadastro.withUpdatedTelefone1Numero(telefone1Numero: String): ClientesCadastro{
        return this.copy(telefone1Numero = telefone1Numero)
    }
    private fun ClientesCadastro.withUpdatedEndereco(endereco: String): ClientesCadastro{
        return this.copy(endereco = endereco)
    }
    private fun ClientesCadastro.withUpdatedEnderecoNumero(enderecoNumero: String): ClientesCadastro {
        return this.copy(enderecoNumero = enderecoNumero)
    }
    private fun ClientesCadastro.withUpdatedBairro(bairro: String): ClientesCadastro {
        return this.copy(bairro = bairro)
    }
    private fun ClientesCadastro.withUpdatedCep(cep: String): ClientesCadastro {
        return this.copy(cep = cep)
    }
    private fun ClientesCadastro.withUpdatedCidade(cidade: String): ClientesCadastro{
        return this.copy(cidade = cidade)
    }
    private fun ClientesCadastro.withUpdatedComplemento(complemento: String): ClientesCadastro {
        return this.copy(complemento = complemento)
    }



}