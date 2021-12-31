package com.poli.prevendasomie.data.remote.DTO

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class ClientesCadastro(
    val bairro: String,
    val bloquear_faturamento: String,
    val cep: String,
    val cidade: String,
    val cidade_ibge: String,
    val cnpj_cpf: String,
    val codigo_cliente_integracao: String,
    val codigo_cliente_omie: Int,
    val codigo_pais: String,
    val complemento: String,
    val contribuinte: String,
    @Contextual
    val dadosBancarios: DadosBancarios,
    val endereco: String,
    @Contextual

    val enderecoEntrega: EnderecoEntrega,
    val endereco_numero: String,
    val estado: String,
    val exterior: String,
    val inativo: String,
    @Contextual

    val info: Info,
    val inscricao_estadual: String,
    val inscricao_municipal: String,
    val nome_fantasia: String,
    val optante_simples_nacional: String,
    val pessoa_fisica: String,
    val razao_social: String,
    @Contextual
    val recomendacoes: Recomendacoes,
    //val tags: List<Tag>
)

