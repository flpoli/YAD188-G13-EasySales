package com.poli.prevendasomie.data.remote.DTO

data class DadosBancarios(
    val agencia: String,
    val codigo_banco: String,
    val conta_corrente: String,
    val doc_titular: String,
    val nome_titular: String
)