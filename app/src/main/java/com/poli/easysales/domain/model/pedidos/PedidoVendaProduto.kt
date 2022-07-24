package com.poli.easysales.domain.model.pedidos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poli.easysales.common.Constants.ORDERS_TABLE

@Entity(tableName = ORDERS_TABLE)
data class PedidoVendaProduto(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @Embedded val cabecalho: Cabecalho = Cabecalho(),
    val det: List<Det>? = emptyList(),
    @Embedded val frete: Frete? = Frete(),
    @Embedded val infoCadastro: InfoCadastro? = InfoCadastro(),
    @Embedded val informacoesAdicionais: InformacoesAdicionais? = InformacoesAdicionais(),
    val listaParcelas: ListaParcelas? = ListaParcelas(),
    @Embedded val observacoes: Observacoes? = Observacoes(),
    @Embedded val totalPedido: TotalPedido? = TotalPedido(),

    )
