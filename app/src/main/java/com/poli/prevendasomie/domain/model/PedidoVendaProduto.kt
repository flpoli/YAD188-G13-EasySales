package com.poli.prevendasomie.domain.model

import com.poli.prevendasomie.domain.model.pedidos.Cabecalho
import com.poli.prevendasomie.domain.model.pedidos.Det
import com.poli.prevendasomie.domain.model.pedidos.Frete
import com.poli.prevendasomie.domain.model.pedidos.InfoCadastro
import com.poli.prevendasomie.domain.model.pedidos.InformacoesAdicionais
import com.poli.prevendasomie.domain.model.pedidos.ListaParcelas
import com.poli.prevendasomie.domain.model.pedidos.Observacoes
import com.poli.prevendasomie.domain.model.pedidos.TotalPedido

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
