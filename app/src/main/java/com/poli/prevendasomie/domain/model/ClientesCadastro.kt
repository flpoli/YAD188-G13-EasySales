package com.poli.prevendasomie.domain.model

data class ClientesCadastro(

    val codClienteOmie: Int,
    val nomeFantasia: String,
    val razaoSocial: String,
    val cnpjCpf: String,
    val telefone1Ddd: String,
    val telefone1Numero: String,
    val email: String,
    val endereco: String,
    val enderecoNumero: String,
    val bairro: String,
    val cep: String,
    val cidade: String,
    val complemento: String

)
