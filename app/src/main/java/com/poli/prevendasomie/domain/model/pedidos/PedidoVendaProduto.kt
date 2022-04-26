package com.poli.prevendasomie.domain.model.pedidos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders_table")
data class PedidoVendaProduto(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cabecalho: Cabecalho?,
    val det: List<Det>?,
    val frete: Frete?,
    val infoCadatro: InfoCadastro?,
    val informacoesAdicionais: InformacoesAdicionais?,
    val listaParcelas: ListaParcelas?,
    val observacoes: Observacoes?,
    val totalPedido: TotalPedido?,

)
