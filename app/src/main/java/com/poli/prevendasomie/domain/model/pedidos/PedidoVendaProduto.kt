package com.poli.prevendasomie.domain.model.pedidos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poli.prevendasomie.common.Constants.ORDERS_TABLE

@Entity(tableName = ORDERS_TABLE)
data class PedidoVendaProduto(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @Embedded val cabecalho: Cabecalho?,
    val det: List<Det>?,
    @Embedded val frete: Frete?,
    @Embedded val infoCadastro: InfoCadastro?,
    @Embedded val informacoesAdicionais: InformacoesAdicionais?,
    val listaParcelas: ListaParcelas?,
    @Embedded val observacoes: Observacoes?,
    @Embedded val totalPedido: TotalPedido?,

)
