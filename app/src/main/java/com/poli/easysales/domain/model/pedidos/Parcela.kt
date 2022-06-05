package com.poli.easysales.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class Parcela(
    @SerializedName("categoria_adiantamento")
    val categoriaAdiantamento: String?,
    @SerializedName("conta_corrente_adiantamento")
    val contaCorrenteAdiantamento: Long?,
    @SerializedName("data_vencimento")
    val dataVencimento: String?,
    @SerializedName("meio_pagamento")
    val meioPagamento: String?,
    @SerializedName("nao_gerar_boleto")
    val naoGerarBoleto: String?,
    @SerializedName("numero_parcela")
    val numeroParcela: Int?,
    @SerializedName("parcela_adiantamento")
    val parcelaAdiantamento: String?,
    @SerializedName("percentual")
    val percentual: Double?,
    @SerializedName("quantidade_dias")
    val quantidadeDias: Int?,
    @SerializedName("tipo_documento")
    val tipoDocumento: String?,
    @SerializedName("valor")
    val valor: Double?
)
