package com.poli.prevendasomie.data.local.entities.pedidos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders_table_test")
data class PedidoVendaEntity(

    @PrimaryKey(autoGenerate = true)
    val orderId: Int = 0,
    val cabecalho: CabecalhoEntity?,

    // @Embedded val det: List<Det>?,
    val frete: FreteEntity?,
    val infoCadastro: InfoCadastroEntity?,
    // val informacoesAdicionais: InformacoesAdicionaisEntity?,
    // @Embedded val listaParcelas: ListaParcelas?,
    // @Embedded val observacoes: ObservacoesEntity?,
    // @Embedded val totalPedido: TotalPedidoEntity?,

)
