package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.local.entities.pedidos.FreteEntity
import com.poli.prevendasomie.domain.model.pedidos.Frete

data class FreteDto(
    @SerializedName("codigo_rastreio")
    val codigoRastreio: String?,
    @SerializedName("codigo_tipo_entrega")
    val codigoTipoEntrega: Int?,
    @SerializedName("codigo_transportadora")
    val codigoTransportadora: Long?,
    @SerializedName("especie_volumes")
    val especieVolumes: String?,
    @SerializedName("marca_volumes")
    val marcaVolumes: String?,
    @SerializedName("modalidade")
    val modalidade: String?,
    @SerializedName("numeracao_volumes")
    val numeracaoVolumes: String?,
    @SerializedName("numero_lacre")
    val numeroLacre: String?,
    @SerializedName("outras_despesas")
    val outrasDespesas: Double?,
    @SerializedName("peso_bruto")
    val pesoBruto: Double?,
    @SerializedName("peso_liquido")
    val pesoLiquido: Double?,
    @SerializedName("placa")
    val placa: String?,
    @SerializedName("placa_estado")
    val placaEstado: String?,
    @SerializedName("previsao_entrega")
    val previsaoEntrega: String?,
    @SerializedName("quantidade_volumes")
    val quantidadeVolumes: Int?,
    @SerializedName("registro_transportador")
    val registroTransportador: String?,
    @SerializedName("valor_frete")
    val valorFrete: Double?,
    @SerializedName("valor_seguro")
    val valorSeguro: Double?,
    @SerializedName("veiculo_proprio")
    val veiculoProprio: String?
)

fun FreteDto.toFrete(): Frete {

    return Frete(
        codigoRastreio = codigoRastreio,
        codigoTipoEntrega = codigoTipoEntrega,
        codigoTransportadora = codigoTransportadora,
        especieVolumes = especieVolumes,
        marcaVolumes = marcaVolumes,
        modalidade = modalidade,
        numeracaoVolumes = numeracaoVolumes,
        numeroLacre = numeroLacre,
        outrasDespesas = outrasDespesas,
        pesoBruto = pesoBruto,
        pesoLiquido = pesoLiquido,
        placa = placa,
        placaEstado = placaEstado,
        previsaoEntrega = previsaoEntrega,
        quantidadeVolumes = quantidadeVolumes,
        registroTransportador = registroTransportador,
        valorFrete = valorFrete,
        valorSeguro = valorSeguro,
        veiculoProprio = veiculoProprio
    )
}

fun FreteDto.toFreteEntity(): FreteEntity {

    return FreteEntity(
        freteId = 0,
        orderId = 0,
        codigoRastreio = codigoRastreio,
        codigoTipoEntrega = codigoTipoEntrega,
        codigoTransportadora = codigoTransportadora,
        especieVolumes = especieVolumes,
        marcaVolumes = marcaVolumes,
        modalidade = modalidade,
        numeracaoVolumes = numeracaoVolumes,
        numeroLacre = numeroLacre,
        outrasDespesas = outrasDespesas,
        pesoBruto = pesoBruto,
        pesoLiquido = pesoLiquido,
        placa = placa,
        placaEstado = placaEstado,
        previsaoEntrega = previsaoEntrega,
        quantidadeVolumes = quantidadeVolumes,
        registroTransportador = registroTransportador,
        valorFrete = valorFrete,
        valorSeguro = valorSeguro,
        veiculoProprio = veiculoProprio
    )
}
