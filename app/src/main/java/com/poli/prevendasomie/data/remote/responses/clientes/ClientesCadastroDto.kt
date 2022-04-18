package com.poli.prevendasomie.data.remote.responses.clientes

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.ClientesCadastro

data class ClientesCadastroDto(
    @SerializedName("bairro")
    val bairro: String,
    @SerializedName("bloquear_exclusao")
    val bloquearExclusao: String,
    @SerializedName("bloquear_faturamento")
    val bloquearFaturamento: String,
    @SerializedName("cep")
    val cep: String,
    @SerializedName("cidade")
    val cidade: String,
    @SerializedName("cidade_ibge")
    val cidadeIbge: String,
    @SerializedName("cnpj_cpf")
    val cnpjCpf: String,
    @SerializedName("codigo_cliente_integracao")
    val codigoClienteIntegracao: String,
    @SerializedName("codigo_cliente_omie")
    val codigoClienteOmie: Long,
    @SerializedName("codigo_pais")
    val codigoPais: String,
    @SerializedName("complemento")
    val complemento: String,
    @SerializedName("contribuinte")
    val contribuinte: String,
    @SerializedName("dadosBancarios")
    val dadosBancarios: DadosBancarios,
    @SerializedName("username")
    val email: String? = "",
    @SerializedName("endereco")
    val endereco: String,
    @SerializedName("enderecoEntrega")
    val enderecoEntrega: EnderecoEntrega,
    @SerializedName("endereco_numero")
    val enderecoNumero: String,
    @SerializedName("estado")
    val estado: String,
    @SerializedName("exterior")
    val exterior: String,
    @SerializedName("inativo")
    val inativo: String,
    @SerializedName("info")
    val info: Info,
    @SerializedName("inscricao_estadual")
    val inscricaoEstadual: String,
    @SerializedName("inscricao_municipal")
    val inscricaoMunicipal: String,
    @SerializedName("nome_fantasia")
    val nomeFantasia: String,
    @SerializedName("optante_simples_nacional")
    val optanteSimplesNacional: String,
    @SerializedName("pessoa_fisica")
    val pessoaFisica: String,
    @SerializedName("razao_social")
    val razaoSocial: String,
    @SerializedName("recomendacoes")
    val recomendacoes: Recomendacoes,
    @SerializedName("tags")
    val tags: List<Tag>,
    @SerializedName("telefone1_ddd")
    val telefone1Ddd: String,
    @SerializedName("telefone1_numero")
    val telefone1Numero: String
)

fun ClientesCadastroDto.toClientesCadastro(): ClientesCadastro {

    return ClientesCadastro(
        codCliIntegracao = codigoClienteIntegracao,
        codClienteOmie = codigoClienteOmie,
        nomeFantasia = nomeFantasia,
        razaoSocial = razaoSocial,
        cnpjCpf = cnpjCpf,
        telefone1Ddd = telefone1Ddd,
        telefone1Numero = telefone1Numero,
        email = email,
        endereco = endereco,
        enderecoNumero = enderecoNumero,
        bairro = bairro,
        cep = cep,
        cidade = cidade,
        complemento = complemento
    )
}
