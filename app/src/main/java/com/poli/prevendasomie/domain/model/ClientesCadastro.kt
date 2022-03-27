package com.poli.prevendasomie.domain.model

@JvmInline
value class Email(val value: String)

data class ClientesCadastro(

    val codClienteOmie: Int? = 0,
    val nomeFantasia: String? = "",
    val razaoSocial: String? = "",
    val cnpjCpf: String?  = "",
    val telefone1Ddd: String?  = "",
    val telefone1Numero: String?  = "",
    var email: String? = "",
    val endereco: String? = "",
    val enderecoNumero: String? = "",
    val bairro: String? = "",
    val cep: String? = "",
    val cidade: String? = "",
    val complemento: String? = ""

)
