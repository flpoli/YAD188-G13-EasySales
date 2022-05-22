package com.poli.prevendasomie.domain.model.clientes


import com.poli.prevendasomie.presentation.clientes.cliente_form.genCodCli


data class ClientesCadastro(


    val codCliIntegracao: String? = genCodCli(),
    val codClienteOmie: Long? = 0,
    val nomeFantasia: String? = "",
    val razaoSocial: String? = "",
    val cnpjCpf: String? = "",
    val telefone1Ddd: String? = "",
    val telefone1Numero: String? = "",
    var email: String? = "",
    val endereco: String? = "",
    val enderecoNumero: String? = "",
    val bairro: String? = "",
    val cep: String? = "",
    val cidade: String? = "",
    val complemento: String? = ""

)
