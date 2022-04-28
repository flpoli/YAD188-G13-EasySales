package com.poli.prevendasomie.data.local.entities.pedidos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders_table")
data class PedidoVendaEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @Embedded val cabecalho: CabecalhoEntity?,
    // @Embedded val det: List<Det>?,
    @Embedded val frete: FreteEntity?,
    @Embedded val infoCadastro: InfoCadastroEntity?,
    @Embedded val informacoesAdicionais: InformacoesAdicionaisEntity?,
    // @Embedded val listaParcelas: ListaParcelas?,
    @Embedded val observacoes: ObservacoesEntity?,
    @Embedded val totalPedido: TotalPedidoEntity?,

)
