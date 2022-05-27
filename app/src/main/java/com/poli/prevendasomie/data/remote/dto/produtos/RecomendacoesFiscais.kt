package com.poli.prevendasomie.data.remote.dto.produtos

import com.google.gson.annotations.SerializedName

data class RecomendacoesFiscais(
    @SerializedName("cnpj_fabricante")
    val cnpjFabricante: String? = "",
    @SerializedName("cupom_fiscal")
    val cupomFiscal: String? = "",
    @SerializedName("id_cest")
    val idCest: String? = "",
    @SerializedName("id_preco_tabelado")
    val idPrecoTabelado: Int? = 0,
    @SerializedName("indicador_escala")
    val indicadorEscala: String? = "",
    @SerializedName("market_place")
    val marketPlace: String? = "",
    @SerializedName("origem_mercadoria")
    val origemMercadoria: String? = ""
)
