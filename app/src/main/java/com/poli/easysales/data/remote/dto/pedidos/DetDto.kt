package com.poli.easysales.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.easysales.domain.model.pedidos.Det

data class DetDto(
    @SerializedName("combustivel")
    val combustivel: CombustivelDto?,
    @SerializedName("ide")
    val ide: Ide?,
    @SerializedName("imposto")
    val imposto: ImpostoDto?,
    @SerializedName("inf_adic")
    val infAdic: InfAdicDto?,
    @SerializedName("observacao")
    val observacao: ObservacaoDto?,
    @SerializedName("produto")
    val produto: ProdutoDto?,
    @SerializedName("rastreabilidade")
    val rastreabilidade: Rastreabilidade?
)

fun DetDto.toDet(): Det {

    return Det(
        ide = ide,
        imposto = imposto?.toImposto(),
        infAdic = infAdic?.toInfAdic(),
        observacao = observacao?.toObservacao(),
        produto = produto?.toProduto(),

    )
}
