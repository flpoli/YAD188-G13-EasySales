package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Frete(
    @SerializedName("codigo_rastreio")
    val codigoRastreio: String?,
    @SerializedName("codigo_tipo_entrega")
    val codigoTipoEntrega: Int?,
    @SerializedName("codigo_transportadora")
    val codigoTransportadora: Int?,
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
    val outrasDespesas: Int?,
    @SerializedName("peso_bruto")
    val pesoBruto: Int?,
    @SerializedName("peso_liquido")
    val pesoLiquido: Int?,
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
    val valorFrete: Int?,
    @SerializedName("valor_seguro")
    val valorSeguro: Int?,
    @SerializedName("veiculo_proprio")
    val veiculoProprio: String?
)
