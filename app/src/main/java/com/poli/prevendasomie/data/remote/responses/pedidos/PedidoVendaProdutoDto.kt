package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto

data class PedidoVendaProdutoDto(
    @SerializedName("cabecalho")
    val cabecalho: CabecalhoDto?,
    @SerializedName("departamentos")
    val departamentos: List<DepartamentoDto>?,
    @SerializedName("det")
    val det: List<DetDto>?,
    @SerializedName("exportacao")
    val exportacao: Exportacao?,
    @SerializedName("frete")
    val frete: FreteDto?,
    @SerializedName("infoCadastro")
    val infoCadastro: InfoCadastroDto?,
    @SerializedName("informacoes_adicionais")
    val informacoesAdicionais: InformacoesAdicionaisDto?,
    @SerializedName("lista_parcelas")
    val listaParcelas: ListaParcelasDto?,
    @SerializedName("observacoes")
    val observacoes: ObservacoesDto?,
    @SerializedName("total_pedido")
    val totalPedido: TotalPedidoDto?
)

fun PedidoVendaProdutoDto.toPedidoVendaProduto(): PedidoVendaProduto {

    return PedidoVendaProduto(
        cabecalho = cabecalho?.toCabecalho(),
        det = det?.map { it.toDet() },
        frete = frete?.toFrete(),
        infoCadatro = infoCadastro?.toInfoCadastro(),
        informacoesAdicionais = informacoesAdicionais?.toInformacoesAdicionais(),
        listaParcelas = listaParcelas?.toListaParcelas(),
        observacoes = observacoes?.toObservacoes(),
        totalPedido = totalPedido?.toTotalPedido()

    )
}
