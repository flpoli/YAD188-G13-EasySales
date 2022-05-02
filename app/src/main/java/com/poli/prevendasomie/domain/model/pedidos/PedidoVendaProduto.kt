package com.poli.prevendasomie.domain.model.pedidos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders_table")
data class PedidoVendaProduto(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val cabecalho: Cabecalho?,
    // @Embedded val det: List<Det>?,
     val frete: Frete?,
     val infoCadastro: InfoCadastro?,
     val informacoesAdicionais: InformacoesAdicionais?,
    // @Embedded val listaParcelas: ListaParcelas?,
    // @Embedded val observacoes: Observacoes?,
     val totalPedido: TotalPedido?,

)
