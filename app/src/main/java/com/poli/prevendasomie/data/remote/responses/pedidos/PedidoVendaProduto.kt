package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class PedidoVendaProduto(
    @SerializedName("cabecalho")
    val cabecalho: Cabecalho?,
    @SerializedName("departamentos")
    val departamentos: List<Departamento>?,
    @SerializedName("det")
    val det: List<Det>?,
    @SerializedName("exportacao")
    val exportacao: Exportacao?,
    @SerializedName("frete")
    val frete: Frete?,
    @SerializedName("infoCadastro")
    val infoCadastro: InfoCadastro?,
    @SerializedName("informacoes_adicionais")
    val informacoesAdicionais: InformacoesAdicionais?,
    @SerializedName("lista_parcelas")
    val listaParcelas: ListaParcelas?,
    @SerializedName("observacoes")
    val observacoes: Observacoes?,
    @SerializedName("total_pedido")
    val totalPedido: TotalPedido?
)
