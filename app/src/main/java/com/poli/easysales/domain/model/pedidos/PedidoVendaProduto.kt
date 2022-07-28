package com.poli.easysales.domain.model.pedidos

data class PedidoVendaProduto(

    val cabecalho: Cabecalho = Cabecalho(),
    val det: List<Det>? = emptyList(),
    val frete: Frete? = Frete(),
    val infoCadastro: InfoCadastro? = InfoCadastro(),
    val informacoesAdicionais: InformacoesAdicionais?,
    val listaParcelas: ListaParcelas? = ListaParcelas(),
    val observacoes: Observacoes? = Observacoes(),
    val totalPedido: TotalPedido? = TotalPedido(),

)
