package com.poli.easysales.data.remote.dto.clientes

import com.google.gson.annotations.SerializedName

data class ClientesCadastroDto(

    @SerializedName("bairro")
    val bairro: String?,
    @SerializedName("bloquear_exclusao")
    val bloquearExclusao: String? = "",
    @SerializedName("bloquear_faturamento")
    val bloquearFaturamento: String? = "",
    @SerializedName("cep")
    val cep: String?,
    @SerializedName("cidade")
    val cidade: String?,
    @SerializedName("cidade_ibge")
    val cidadeIbge: String? = "",
    @SerializedName("cnpj_cpf")
    val cnpjCpf: String? = "",
    @SerializedName("codigo_cliente_integracao")
    val codigoClienteIntegracao: String? = "",
    @SerializedName("codigo_cliente_omie")
    val codigoClienteOmie: Long? = 0,
    @SerializedName("codigo_pais")
    val codigoPais: String? = "",
    @SerializedName("complemento")
    val complemento: String? = "",
    @SerializedName("contribuinte")
    val contribuinte: String? = "",
    @SerializedName("dadosBancarios")
    val dadosBancarios: DadosBancarios? = DadosBancarios(),
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("endereco")
    val endereco: String? = "",
    @SerializedName("enderecoEntrega")
    val enderecoEntrega: EnderecoEntrega? = EnderecoEntrega(),
    @SerializedName("endereco_numero")
    val enderecoNumero: String? = "",
    @SerializedName("estado")
    val estado: String? = "",
    @SerializedName("exterior")
    val exterior: String? = "",
    @SerializedName("inativo")
    val inativo: String? = "",
    @SerializedName("info")
    val info: Info? = Info(),
    @SerializedName("inscricao_estadual")
    val inscricaoEstadual: String? = "",
    @SerializedName("inscricao_municipal")
    val inscricaoMunicipal: String? = "",
    @SerializedName("nome_fantasia")
    val nomeFantasia: String? = "",
    @SerializedName("optante_simples_nacional")
    val optanteSimplesNacional: String? = "",
    @SerializedName("pessoa_fisica")
    val pessoaFisica: String? = "",
    @SerializedName("razao_social")
    val razaoSocial: String? = "",
    @SerializedName("recomendacoes")
    val recomendacoes: Recomendacoes? = Recomendacoes(),
    @SerializedName("tags")
    val tags: List<TagDto>? = emptyList(),
    @SerializedName("telefone1_ddd")
    val telefone1Ddd: String? = "",
    @SerializedName("telefone1_numero")
    val telefone1Numero: String? = ""
)
