package com.poli.easysales.data.local.entities.pedidos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "frete_entity")
data class FreteEntity(
    val codigoRastreio: String?,
    val codigoTipoEntrega: Int?,
    val codigoTransportadora: Long?,
    val especieVolumes: String?,
    val marcaVolumes: String?,
    val modalidade: String?,
    val numeracaoVolumes: String?,
    val numeroLacre: String?,
    val outrasDespesas: Double?,
    val pesoBruto: Double?,
    val pesoLiquido: Double?,
    val placa: String?,
    val placaEstado: String?,
    val previsaoEntrega: String?,
    val quantidadeVolumes: Int?,
    val registroTransportador: String?,
    val valorFrete: Double?,
    val valorSeguro: Double?,
    val veiculoProprio: String?
)
