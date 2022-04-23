package com.poli.prevendasomie.domain.model.pedidos

data class PedidoVendaProduto(

    val cabecalho: Cabecalho?,
    val det: List<Det>?,
    val frete: Frete?,
    val infoCadatro: InfoCadastro?,
    val informacoesAdicionais: InformacoesAdicionais?,
    val listaParcelas: ListaParcelas?,
    val observacoes: Observacoes?,
    val totalPedido: TotalPedido?,

)
