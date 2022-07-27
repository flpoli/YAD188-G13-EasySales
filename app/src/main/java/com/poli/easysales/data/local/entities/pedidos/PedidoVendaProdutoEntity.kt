package com.poli.easysales.data.local.entities.pedidos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poli.easysales.common.Constants


@Entity(tableName = Constants.ORDERS_TABLE)
data class PedidoVendaProdutoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @Embedded val cabecalho: CabecalhoEntity,
    val det: List<DetEntity>? = emptyList(),
    @Embedded val frete: FreteEntity?,
    @Embedded val infoCadastro: InfoCadastroEntity?,
    @Embedded val informacoesAdicionais: InformacoesAdicionaisEntity?,
    val listaParcelas: ListaParcelasEntity?,
    @Embedded val observacoes: ObservacoesEntity?,
    @Embedded val totalPedido: TotalPedidoEntity?
)
