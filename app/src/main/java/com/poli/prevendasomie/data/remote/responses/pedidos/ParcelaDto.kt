package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.pedidos.Parcela

data class ParcelaDto(
    @SerializedName("categoria_adiantamento")
    val categoriaAdiantamento: String?,
    @SerializedName("conta_corrente_adiantamento")
    val contaCorrenteAdiantamento: Int?,
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

fun ParcelaDto.toParcela(): Parcela {

    return Parcela(
        categoriaAdiantamento = categoriaAdiantamento,
        contaCorrenteAdiantamento = contaCorrenteAdiantamento,
        dataVencimento = dataVencimento,
        meioPagamento = meioPagamento,
        naoGerarBoleto = naoGerarBoleto,
        numeroParcela = numeroParcela,
        parcelaAdiantamento = parcelaAdiantamento,
        percentual = percentual,
        quantidadeDias = quantidadeDias,
        tipoDocumento = tipoDocumento,
        valor = valor

    )
}
