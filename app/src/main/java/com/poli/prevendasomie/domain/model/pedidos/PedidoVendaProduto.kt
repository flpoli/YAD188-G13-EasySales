package com.poli.prevendasomie.domain.model.pedidos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders_table")
data class PedidoVendaProduto(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @Embedded val cabecalho: Cabecalho?,
    @Embedded val det: List<Det>?,
    @Embedded val frete: Frete?,
    @Embedded val infoCadastro: InfoCadastro?,
    @Embedded val informacoesAdicionais: InformacoesAdicionais?,
    val listaParcelas: ListaParcelas?,
    @Embedded val observacoes: Observacoes?,
    @Embedded val totalPedido: TotalPedido?,

)
